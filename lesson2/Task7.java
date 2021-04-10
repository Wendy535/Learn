package geekBrains.lesson2;

import java.util.Arrays;

public class Task7 {
    public static void main (String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        //Чтобы было проще сравнивать
        System.out.println(Arrays.toString(arr));
        int[] result = new int[7];
        int n = 2;
        int l = arr.length;
        for (int x = 0; x < l ; x++) {
            if ((x + n) < l) {
                result[x + n] = arr[x];
            }
            if ((x + n) >= l) {
                result[x + n - l] = arr[x];
            }
        }
        System.out.println(Arrays.toString(result));
        //Работает для всех сдвигов вправо, для сдвигов влево нужно чуть переписать индексы
    }
}
