package geekBrains.lesson1;

import java.util.Scanner;

public class Task4 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (x >= 0) {
            System.out.println(x + " - положительное число");
        }
        else {
            System.out.println(x + " - отрицательное число");
        }
    }
}
