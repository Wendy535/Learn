package geekBrains.lesson9;

public class Task1to4 {

    public static void main (String[] args) {

        String[][] longArray = new String[][] {
            { "5", "4", "3", "2"},
            { "1", "0", "oh", "0"},
            { "9", "8", "wtf", "7"},
            {"6", "5", "4", "repeat"}
        };

        String[][] shortArray = new String[][] {
            {"wake", "me", "up"},
            {"when", "september", "ends"}
        };

        dealWithArray(shortArray);
        dealWithArray(longArray);
    }

    public static void dealWithArray(String[][] array) {
        int m = array.length;
        int n = array[0].length;
        int sum = 0;
        int y = 0;
        int x = 0;
        int number = 0;
        if (m != 4 || n != 4) {
            try {
                throw new IndexOutOfBoundsException("MyArraySizeException");
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e + ": Вы передаете массив с неверными параметрами");
            }
        } else {
            for (x = 0; x < m; x++) {
                for (y = 0; y < n; y++) {
                    try {
                        number = Integer.valueOf(array[y][x]);
                        sum += number;
                    } catch (Throwable MyArrayDataException){
                            System.out.println(MyArrayDataException + " Объект с координатами " + y + " " + x + " не является числом");
                    }
                }
            }
            System.out.println("Сумма чисел в масиве равна " + sum);
        }
    }
}
