package geekBrains.lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task2 {

    static String[] words = {"apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
            "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
            "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int index = random.nextInt(24);
    static String item = words[index];
    static String userGuess = "";
    static ArrayList stars = new ArrayList(Arrays.asList('*', '*', '*', '*', '*', '*', '*', '*', '*', '*'));

    public static void main(String[] args) {
        veggyFruityQuiz();
    }

    public static void veggyFruityQuiz() {
        System.out.println("Мы загадали слово. Угадаете?");
        while (true) {
            String userGuess = scanner.nextLine();
            String[] arr1 = userGuess.split("");
            String[] arr2 = item.split("");
            if (userGuess.equals(item)) {
                System.out.println("Вы угадали! Хотите еще?");
                restartQuiz();
            } else {
                System.out.println("Ничего страшного. Попробуйте еще");
                int mm = Math.min(arr1.length, arr2.length);
                for (int x = 0; x < mm; x++) {
                    if (arr1[x].equals(arr2[x])) {
                        System.out.println("В нашем слове тоже есть буква " + arr1[x]);
                    }
                }
            }
        }
    }

    public static void restartQuiz() {
        System.out.println("Хотите сыграть еще?  yes/no");
        String answer = scanner.nextLine();
        switch (answer) {
            case "no" :
                System.out.println("Спасибо за игру.");
            case "yes":
                stars.clear();
                index = random.nextInt(24);
                item = words[index];
                veggyFruityQuiz();
            default:
                System.out.println("Хотите сыграть еще? yes/no");
        }

    }

}
