package geekBrains.lesson2;

public class Task6 {
    public static void main (String[] args) {
        int[] arr = {2, 2, 2, 1,  2, 2, 10, 1};
        // Решаю на примере вашего массива, хотя веселее было бы использовать Random()
        int totalSum = 0;
        for (int x: arr) {
            totalSum += x;
        }
        int partOf = 0;
        for (int x = 0; x < arr.length; x++) {
            partOf += arr[x];
            totalSum -= arr[x];
                if (partOf == totalSum) {
                    System.out.println("true");
                }

        }

    }
}
