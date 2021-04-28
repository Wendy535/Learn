package geekBrains.lesson7;

public class Task1to6 {

    public static void main (String[] args) {
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Барсик", 5, false);
        cats[1] = new Cat("Снежок", 3, false);
        cats[2] = new Cat("Бандит", 6, false);
        cats[3] = new Cat("Мурка", 6, false);
        Plate plate = new Plate(15);
        plate.plateInfo();
        cats[0].eat(plate);
        plate.plateInfo();

        for (Cat c: cats) {
            c.eat(plate);
            plate.plateInfo();
        }

        for (Cat c: cats) {
            c.isCatFull();
        }



    }
}

class Cat {
    String name;
    int appetite;
    boolean fullness;

    public Cat (String name, int appetite, boolean fullness) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = fullness;
    }

    public void eat(Plate p) {
        if (fullness == true) {
            System.out.println(name + " не хочет есть.");
        }

        if (fullness == false && p.food >= appetite) {
            p.decreaseFood(appetite);
            fullness = true;
            System.out.println(name + " съел(а) " + appetite + " единиц корма и полностью сыт(а)");
        }
        else if (fullness == false && p.food < appetite) {
            System.out.println("В тарелке недостаточно корма, " + name + " не может поесть.");
        }
    }

    public void isCatFull() {
        if (fullness == true) {
            System.out.println(name + " сыт(а)");
        } else {
            System.out.println(name + " хочет есть.");
        }
    }

}

class Plate {
    public  int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
            food -= n;
    }

    public void addFood(int n) {
        food += n;
    }

    public void plateInfo() {
        if (food > 5) {
            System.out.println("Осталось корма: " + food + " единиц.");
        } else if (food <= 5) {
            System.out.println("В тарелке остается мало корма: " + food + " единиц. Хотите добавить?");
        }
    }

}