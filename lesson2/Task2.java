package geekBrains.lesson2;

import java.util.Arrays;

public class Task2 {
    public static void main (String[] args) {
        int[] arr = new int[8];
        arr[0] = 0;
        for (int x = 1; x < 8; x++) {
            arr[x] = (arr[x - 1]) + 3;
        }
        System.out.println(Arrays.toString(arr));
;    }
}
