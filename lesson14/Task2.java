package geekBrains.lesson14;

public class Task2 {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{1, 1, 4, 4};
        Integer[] arr2 = new Integer[] {1, 1, 1};
        Integer[] arr3 = new Integer[] {1, 2, 3, 4};

        System.out.println(Task2.oneAndFour(arr1));
        System.out.println(Task2.oneAndFour(arr2));
        System.out.println(Task2.oneAndFour(arr3));


    }

    public static boolean oneAndFour(Integer[] array) {
        int oneCounter = 0;
        int fourCounter = 0;
        int other = 0;
        for (Integer i: array) {
            if (i == 1) {
                oneCounter++;
            }
            else if (i == 4) {
                fourCounter++;
            }
            else if (i != 1 && i != 4) {
                other++;
                return false;
            }
        }
        if (fourCounter > 0 && oneCounter > 0 && other == 0) {
            return true;
        } else {
            return false;
        }
    }
}
