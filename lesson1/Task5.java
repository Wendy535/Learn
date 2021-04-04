package geekBrains.lesson1;

import java.util.Scanner;

public class Task5 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        plusMinus(number);
    }

    public static boolean plusMinus(int a) {
        boolean c;
        if (a >= 0) {
            c = false;
            System.out.println(c);
        } else {
            c = true;
            System.out.println(c);
        }
        return c;
    }
}
