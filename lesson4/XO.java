package geekBrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class XO {

    static final Scanner scanner = new Scanner(System.in);
    static final Random random = new Random();
    static final char DOT_EMPTY = '•';
    static char dotHuman;
    static char dotAi;
    static char[][] field;
    static int fieldSizeX;
    static int fieldSizeY;
    static char symbol;
    static int difficulty;

    public static void main(String[] args) {

        while (true) {
            fieldSettings();
            System.out.println("Отлично! Вот ваше игровое поле:");
            printField();
            difficulty = diffiсultyChoice();
            symbol = symbolChoice();
            while (true) {
                if (symbol == 'X') {
                        humanTurn();
                        printField();
                        if (gameChecks(dotHuman)) {
                             break;
                        }
                        if (difficulty == 1) {
                            aiTurnLight();
                            printField();
                            if (gameChecks(dotAi)) {
                                break;
                            }
                        } else if (difficulty == 2) {
                            aiTurnHard();
                            printField();
                            if (gameChecks(dotAi)) {
                                break;
                            }
                        }
                }
                if (symbol == '0') {
                        if (difficulty == 1) {
                            aiTurnLight();
                            printField();
                            if (gameChecks(dotAi)) {
                                break;
                            }
                        }
                        if (difficulty == 2) {
                            aiTurnHard();
                            printField();
                            if (gameChecks(dotAi)) {
                                break;
                            }
                        }
                        humanTurn();
                        printField();
                        if (gameChecks(dotHuman)) {
                            break;
                        }
                }
            }
            System.out.println("Игра закончена. Хотите сыграть еще? 1 - да, 0 - нет.");
            int restart = scanner.nextInt();
            if (restart != 1) {
                break;
            }
        }
    }

    public static void fieldSettings() {
        System.out.println("Добро пожаловать в игру \"Крестики-нолики\".");
        System.out.println("Правила очень простые. Вам нужно выбрать размеры игрового поля.");
        System.out.println("Далее вы и компьютер ходите последовательно, чтобы собрать");
        System.out.println("3 элемента в ряд. Ничего сложного, правда? Удачи!");
        System.out.println("Введите размер для квадратного игрового поля");
        fieldSizeX = scanner.nextInt();
        fieldSizeY = fieldSizeX;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++)
                field[y][x] = DOT_EMPTY;
        }
    }

    public static void printField() {
        System.out.print("-");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print(i % 2 == 0 ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i <= fieldSizeX * 2 + 1; i++)
            System.out.print("-");
        System.out.println();
    }

    public static char symbolChoice() {
        char inc2;
        System.out.println("Выберите за кого вы будете играть.");
        System.out.println("Крестики ходят первыми. Но нолики - это для профессионалов.");
        System.out.println("Введите X или 0");
        while (true) {
            inc2 = scanner.next().charAt(0);
            if (inc2 == '0') {
                symbol = inc2;
                System.out.println("Вы играете за нолики. Начинает компьютер.");
                break;
            }
            if (inc2 == 'X') {
                symbol = inc2;
                System.out.println("Вы играете за крестики и ходите первым.");
                break;
            } else {
                System.out.println("Введите X или 0");
            }
        }
        return symbol;
    }

    public static int diffiсultyChoice() {
        int diff = 0;
        System.out.println("Теперь выберите сложность игры.");
        System.out.println("Сложность 1 хороша для тренировки. Компьютер не доставит вам проблем.");
        System.out.println("На сложности 2 он будет анализировать ваши действия и мешать.");
        System.out.println("Введите желаемую сложность - 1 или 2");
        int inc = scanner.nextInt();
        switch (inc) {
            case 1: { System.out.println("Отлично, играем в простую игру.");
            diff = inc;
            break; }
            case 2:  { System.out.println("Отлично, играем в сложную игру.");
            diff = inc;
            break;}
            default: {System.out.println("Введите 1 или 2");
                inc = scanner.nextInt();}
        }
        return diff;
    }

    public static boolean cellEmpty(int x, int y) {
        if (field[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void humanTurn() {
        dotHuman = symbol;
        System.out.println("Введите координаты ячейки в формате двух цифр через пробел.");
        System.out.println("Первая цифра - координаты по горизонтали, вторая - по вертикали");
        int x, y;
        x = scanner.nextInt() - 1;
        y = scanner.nextInt() - 1;
        field[y][x] = dotHuman;
    }

    public static void aiTurnLight() {
        dotAi = (dotHuman == 'X') ? '0' : 'X';
        System.out.println("Ходит компьютер.");

        int x, y;
        while (true) {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
            if (cellEmpty(x, y)) {
                field[y][x] = dotAi;
                break;
            }
        }
    }

    public static boolean checkRows(char dot, int counter) {
        int rowCounter = 0;
        int a = 0;
        int b = 0;
        while (b < fieldSizeY) {
            for (a = 0; a < fieldSizeX; a++) {
                if (field[b][a] == dot) rowCounter += 1;
                    if (rowCounter == counter) return true;
            }
            b++;
            rowCounter = 0;
        }
        return false;
    }

    public static boolean checkVert (char dot, int counter) {
        int colCounter = 0;
        int a = 0;
        int b = 0;
        while (a < fieldSizeX) {
            for (b = 0; b < fieldSizeY; b++) {
                if (field[b][a] == dot) colCounter += 1;
                    if (colCounter == counter) return true;
            }
            colCounter = 0;
            a++;
        }
        return false;
    }

    public static boolean checkDiag1 (char dot, int counter) {
        int diagCounter1 = 0;
        int a = 0;
        int b = 0;
        for (a = 0; a < fieldSizeX; a++) {
            for (b = 0; b < fieldSizeY; b++) {
                if (a == b && field[b][a] == dot) diagCounter1 += 1;
                    if (diagCounter1 == counter) return true;
            }
        }
        return false;
    }

    public static boolean checkDiag2 (char dot, int counter) {
        int diagCounter2 = 0;
        int a = 0;
        int b = fieldSizeY - 1;
        while (b >= 0) {
            for (a = 0; a < fieldSizeX; a++) {
                if (a == b - 2 && field[b][a] == dot) {
                    diagCounter2 += 1;
                    if (diagCounter2 == counter) return true;
                } else if (b == a - 2 && field[b][a] == dot) {
                    diagCounter2 += 1;
                    if (diagCounter2 == counter) return true;
                } else if (a == b && field[b][a] == dot) {
                    diagCounter2 += 1;
                    if (diagCounter2 == counter) return true;
                }
                b--;
           }
        }
        return false;
    }

    public static boolean checkDraw() {
        int x, y;
        for (x = 0; x < fieldSizeX; x++) {
            for (y = 0; y < fieldSizeY; y++) {
                if (field[y][x] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void aiTurnHard() {
        dotAi = (dotHuman == 'X') ? '0' : 'X';
        System.out.println("Ходит компьютер.");

        if (checkRows(dotHuman, 2)) {
            int a = 0;
            int b = 0;
            while (b < fieldSizeY) {
                for (a = 0; a < fieldSizeX; a++) {
                    if (field[b][a] == dotHuman) {
                        while (true) {
                            a = random.nextInt(fieldSizeX);
                            if (cellEmpty(a, b)) {
                                field[b][a] = dotAi;
                                break;
                            }
                            if (!cellEmpty(a, b)) break;
                        }
                    }
                }
                b++;
            }
        }

        else if (checkVert(dotHuman, 2)) {
            int a = 0;
            int b = 0;
            while (a < fieldSizeX) {
                for (b = 0; b < fieldSizeY; b++) {
                    if (field[b][a] == dotHuman) {
                        while (true) {
                            b = random.nextInt(fieldSizeY);
                            if (cellEmpty(a, b)) {
                                field[b][a] = dotAi;
                                break;
                            }
                            if (!cellEmpty(a, b)) break;
                        }
                    }
                }
                a++;
            }
        }

        else {
            while (true) {
                int a = random.nextInt(fieldSizeX);
                int b = random.nextInt(fieldSizeY);
                if (cellEmpty(a, b)) {
                    field[b][a] = dotAi;
                    break;
                }
            }
        }
    }

    public static boolean gameChecks(char dot) {
        if (checkRows(dot, 3) || checkVert(dot, 3) || checkDiag1(dot, 3) || checkDiag2(dot, 3)) {
            if (dot == dotHuman) System.out.println("Победил человек!");
            if (dot == dotAi) System.out.println("Победил компьютер");
            return true;
        }

        if (checkDraw()) {
            System.out.println("У нас ничья!");
            return true;
        }

        System.out.println("Игра продолжается.");
        return false;
    }

}