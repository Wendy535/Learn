package geekBrains.lesson2;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 0, 1, 1, 0, 1};
        int[] arr2 = new int[8];
        for (int x = 0; x < arr.length; x++) {
            if (arr[x] == 1 ) {
                arr2[x] = 0;
            } else {
                arr2[x] = 1;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
}
