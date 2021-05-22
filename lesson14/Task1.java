package geekBrains.lesson14;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1 {

    public static void main(String[] args) throws MyException {

        Integer[] numbers = new Integer[]{1, 3, 6, 8, 2, 4, 5, 5};
        Integer[] numbers2 = new Integer[]{3, 2, 4, 8, 8, 9, 6};
        Integer[] numbers3 = new Integer[] {1, 2, 3};
        System.out.println(Arrays.toString(getArray(numbers)));
        System.out.println(Arrays.toString(getArray(numbers2)));
        System.out.println(Arrays.toString(getArray(numbers3)));

    }

    public static Integer[] getArray(Integer[] array)   {
        int counter = 0;
        int num = 0;
        for (int x = 0; x < array.length; x++) {
            if (array[x] == 4) {
                counter++;
                num = x;
            }
        }

        Integer[] numbers = new Integer[0];
        try {
            if (counter == 0) {
                throw new RuntimeException("В массиве нет четверок :(");
            } else {
                numbers = new Integer[array.length - num - 1];
                System.arraycopy(array, num + 1, numbers, 0, array.length - num - 1);
            }
        } catch (MyException e) {
            System.out.println("В массиве нет четверок :(");
        }
        return numbers;
    }
}

class MyException extends RuntimeException {
    String message;

    public MyException(String message) {
        this.message = message;
    }
}

