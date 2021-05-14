package geekBrains.lesson11;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Task1 {

    public static void main (String[] args) {
        Integer[] nums = new Integer[] {1, 2, 3, 4, 5};
        String[] words = new String[] {"one","two", "three", "four", "five"};


        changeArray(nums, 2, 3);
        changeArray(words, 0, 3);

    }

    public static <T> void changeArray(T [] arr, int a, int b) {
        T object;
        object = (T) arr[a];
        arr[a] = arr [b];
        arr[b] = (T) object;
        System.out.println(Arrays.toString(arr));
    }
}
