package geekBrains.lesson12;



public class Task1 {

    public static final int SIZE = 10000000;
    public static final int HALF = SIZE/2;
    public static float[] arr = new float[SIZE];
    static float[] arrHalf1 = new float[HALF];
    static float[] arrHalf2 = new float[HALF];

    public static void main(String[] args) {
        task();

    }

    public static void task() {
        System.out.println("Наполнение массива...");
        for (int x = 0; x < SIZE; x++ ) {
            arr[x] = 1;
        }
        System.out.println("Массив заполнен знаками 1");
        System.arraycopy(arr, 0, arrHalf1, 0, HALF);
        System.arraycopy(arr, HALF, arrHalf2, 0, HALF);
        System.out.println("Массив разбит на два массива для обработки");

        System.out.println("Выполняем решение задачи в один поток");
        method1();

        System.out.println("Выполняем решение задачи в два потока");
        method2();
    }

    public static void method1() {
        System.out.println("Переопределение значений массива...");
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }
        System.out.println("Переопределение массива завершено");
        System.out.println(arr[15]);
        System.out.println(arr[5000001]);
        System.out.println(arr.length);
        long b = System.currentTimeMillis();
        System.out.println("Время выполнения операции - " + (b - a));

    }

    public static void method2() {
        long a = System.currentTimeMillis();
        System.out.println("Переопределение значений массивов...");
        MyThread thread1 = new MyThread("Thread1", arrHalf1);
        MyThread thread2 = new MyThread("Thread2", arrHalf2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arrHalf1, 0, arr, 0, 5000000);
        System.arraycopy(arrHalf2, 0, arr, 5000001, 500000);
        System.out.println(arr.length);
        System.out.println(arr[15]);
        System.out.println(arr[5000001]);
        long b = System.currentTimeMillis();
        System.out.println("Время выполнения операции - " + (b - a));
    }

    static class MyThread extends Thread {
        private final float[] array;
        public String name;

        MyThread(String name, float[] array) {
            super(name);
            this.array = array;
        }

        public void run() {
            for (int n = 0; n < array.length / 2; n++) {
                array[n] = (float) (arr[n] * Math.sin(0.2f + n / 5) * Math.cos(0.2f + n / 5) * Math.cos(0.4f + n / 2));
            }
            System.out.println(array.getClass().getName());
            System.out.println(array.length);
        }

    }

}
