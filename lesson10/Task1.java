package geekBrains.lesson10;

import java.util.*;

public class Task1 {

    public static void main (String[] args) {

        String[] arrayOfWords = new String[]{
            "apple",
            "cucumber",
            "peach",
            "apple",
            "tomato",
            "pineapple",
            "watermelon",
            "potato",
            "pineapple",
            "melon",
            "pepper",
            "pineapple",
            "cherry"
        };

        //Вывод уникальных элементов
        HashSet<String> setOfWords = new HashSet<>(Arrays.asList(arrayOfWords));
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(arrayOfWords));

        System.out.println();

        System.out.println("Список уникальных элементов: ");
        System.out.println(setOfWords);

        System.out.println();

        ArrayList<String> listOfWords = new ArrayList<>(Arrays.asList(arrayOfWords));
        ListIterator<String> iter = listOfWords.listIterator();
        HashMap<String, Integer> map = new HashMap<>();
        while (iter.hasNext()) {
            String str = iter.next();
            map.put(str, Collections.frequency(listOfWords, str));
        }
        System.out.println("Число повторений каждого элемента в исходном массиве: ");
        System.out.println(map);
    }

}
