package geekBrains.lesson2;

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        int[] arr = {11, 3, 1, 5, 9, 6, 8, 3, 2};
        int max = 0;
        for (int x = 1; x < arr.length; x = x + 2) {
            if (arr[x] > arr[x - 1]) {
                if (arr[x] > max) {
                    max = arr[x];
                }
            }
            else {
                if (arr[x - 1] > max) {
                    max = arr[x - 1];
                }
            }
        }
        System.out.println(max);

        /* Далее тем же способом ищем min, вывожу в отдельный блок только чтобы
        не нагромождать */

        int min = max;
        for (int x = 1; x < arr.length; x = x + 2) {
            if (arr[x] < arr[x - 1]) {
                if (arr[x] < min) {
                    min = arr[x];
                }
            } else {
                if (arr[x - 1] < min) {
                    min = arr[x - 1];
                }
            }
        }

        System.out.println(min);
    }
}
