package geekBrains.lesson1;

public class Task2 {
    public static void main(String[] args) {
        float a = 2.1f;
        float b = 5.15f;
        float c = 1.88f;
        float d = 4.6f;

        System.out.println(numbers(a, b, c, d));
    }

    public static float numbers(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

}
