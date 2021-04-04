package geekBrains.lesson1;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(compare(15,2));
        System.out.println(compare(4, 44));
        System.out.println(compare(20, 0));
    }

    public static boolean compare(int a, int b) {
        boolean c;
        if (a + b >= 10 && a + b <= 20) {
            c = true;
        }
        else {
            c = false;
        }
        return c;
    }

}
