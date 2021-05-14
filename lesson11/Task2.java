package geekBrains.lesson11;

import sun.security.jca.GetInstance;

import java.util.ArrayList;

public class Task2 {

    public static void main (String[] args) {
        String[] words = new String[] {"one", "two", "three", "four", "five"};
        Integer[] nums = new Integer[] {1, 2, 3, 4, 5};
        System.out.println(changeArray(words).getClass());
        System.out.println(changeArray(nums).getClass());

    }

    public static <T> ArrayList<T> changeArray(T[] array) {
        ArrayList<T> list = new ArrayList();
        for (int x = 0; x < array.length; x++) {
            list.add(array[x]);
        }
        return list;
    }
}
