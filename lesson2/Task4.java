package geekBrains.lesson2;

import java.util.Scanner;
import java.util.Arrays;

public class Task4 {
    public static void main (String[] args) {
        int[][] arr = new int[2][2];
            for (int i = 0; i < 2; i++) {
                for (int x = 0; x < 2; x++) {
                    if (i == x) {
                        arr[i][x] = 1;
                    } else {
                        arr[i][x] = 0;
                    }
                }
            }
        System.out.println(Arrays.deepToString(arr).replace("], ", "]\n"));

    }
}
