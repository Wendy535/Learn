package geekBrains.lesson2;

import java.util.Arrays;

public class Task3 {
    public static void main (String[] args) {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] arr2 = new int[arr.length];
        for (int x = 0; x < arr.length; x++) {
            if (arr[x] < 6) {
                arr2[x] = arr[x] * 2;
            } else {
                arr2[x] = arr[x];
            }
        }
        System.out.println(Arrays.toString(arr2));
    }
}
