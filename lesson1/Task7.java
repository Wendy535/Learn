package geekBrains.lesson1;

import java.util.Scanner;

public class Task7 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        isBadYear(year);
    }

    public static String isBadYear(int a) {
        String c;
        if (a%4 != 0) {
            c = " is a good year";
        }
        else if (a%4 == 0 && a% 100 == 0) {
                c = " is a good year";
                if (a%400 == 0) {
                    c = " is a bad year";
                }
        } else {
            c = " is a bad year";
        }

        System.out.println(a + c);
        return c;
    }
}
