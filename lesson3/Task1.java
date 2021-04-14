package geekBrains.lesson3;

import java.util.Scanner;
import java.util.Random;

public class Task1 {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int num = random.nextInt(10);
    static int counter = 1;
    static int userGuess = 0;

    public static void main(String[] args) {
        numberGame();
    }

    public static void numberGame() {
        System.out.println("Мы загадали число от 0 до 9. Угадаете?");


        while (counter <= 3) {
            userGuess = scanner.nextInt();
            if (userGuess >= 0 && userGuess < 10) {
                if (userGuess == num) {
                    System.out.println("Угадали!");
                    askForRepeat();
                } else {
                    counter += 1;
                    if (userGuess > num) {
                        System.out.println("Наше число меньше");
                    } else {
                        System.out.println("Наше число больше");
                    }

                }
            }
            else if (userGuess < 0 || userGuess > 9) {
                System.out.println("Нужно число в диапазоне от 0 до 9");
            }
        }
        if (counter > 3) {
            System.out.println("Не получилоcь. Попробуете еще?");
            askForRepeat();
        }
    }

    public static void askForRepeat() {
        System.out.println("Повторить игру еще раз? 1 - да/ 0 - нет");
        int x = scanner.nextInt();
        if (x == 0|| x == 1) {
            switch (x) {
                case 0:
                    System.out.println("Спасибо за игру. Завершение программы..");
                    break;
                case 1:
                    counter = 1;
                    numberGame();
            }
        } else {
            System.out.println("Повторить игру еще раз? 1 - да/ 0 - нет");
        }
    }
}