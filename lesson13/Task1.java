package geekBrains.lesson13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Task1 {
    public static final int CARS_COUNT = 4;
    static final CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Car[] cars = new Car[CARS_COUNT];
        Race race = new Race(new Road(60), new Tunnel(), new Road(40), new Finish(10, "Финишная прямая"));
        Thread[] threads = new Thread[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
            threads[i] = new Thread(cars[i]);
            try {
                System.out.println(cars[i].name + " готовится");
                Thread.sleep(500 + (int) (Math.random() * 800));
                cdl.countDown();
                System.out.println(cars[i].name + " готов");
            } catch (InterruptedException e) {
            }
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
        }

        System.out.println("Все участники готовы к гонке");
        System.out.println("ПОЕХАЛИ!!");

        for (Thread t: threads) {
            t.start();
        }

    }
}

class Car implements Runnable {
    Semaphore smp = new Semaphore(CARS_COUNT);
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    public String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
    }
}

abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}
class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Tunnel extends Stage {
    Semaphore smp = new Semaphore(2, true);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smp.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Finish extends Stage {
    Semaphore smp = new Semaphore(1);
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }

    public Finish(int length, String description) {
        this.length = length;
        this.description = "Финишая прямая";
    }

    @Override
    public void go(Car c) {
            System.out.println(c.getName() + " пересекает финишную прямую!!!");
    }
}

class Race {
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
