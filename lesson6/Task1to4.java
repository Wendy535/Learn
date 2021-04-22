package geekBrains.lesson6;

public class Task1to4 {

    public static void main (String[] args) {

        Animal lion = new Animal("Лев");
        Animal cheetah = new Animal("Гепард");
        lion.swim(200);
        cheetah.run(800);
        Cat basil = new Cat("Кот", "Василий", "белый");
        Cat gang = new Cat("Кот", "Бандит", "черный");
        Dog buddy = new Dog("Собака", "Дружок");
        Dog snowball = new Dog("Собака", "Снежок");
        basil.swim(5);
        snowball.swim(15);
        gang.run(150);
        buddy.run(300);
        Animal.getCounter();
    }
}

class Animal {
    String breed;
    static int counter;

    public Animal (String breed) {
        this.breed = breed;
        counter ++;
    }

    static void getCounter() {
        System.out.println("У нас " + counter + " животных.");
    }

    void run(int distance) {
        System.out.println(breed + " пробежал(а) " + distance + " метров");
    }

    void swim(int distance) {
        System.out.println(breed + " проплыл(а) " + distance + " метров.");
    }
}

class Cat extends Animal {
    String name;
    String color;

    public Cat(String breed, String name, String color) {
        super(breed);
        this.name = name;
        this.color = color;
    }

    @Override
    void run(int distance) {
        if (distance <= 200) System.out.println(breed + " " + name + " " + " пробежал(а) " + distance + " м");
        if (distance > 200) System.out.println(breed + " не может столько пробежать");
    }

    @Override
    void swim (int distance) {
        System.out.println(breed + " не может плавать.");
    }
}

class Dog extends Animal {
    String name;

    public Dog(String breed, String name) {
        super(breed);
        this.name = name;
    }

    @Override
    void run(int distance) {
        if (distance <= 500) System.out.println(breed + " " + name + " " + " пробежал(а) " + distance + " м");
        if (distance > 500) System.out.println(breed + " не может столько пробежать");
    }

    @Override
    void swim (int distance) {
        if (distance <= 10) System.out.println(breed + " " + name + " " + "проплыл(а) " + distance + " м");
        if (distance > 10) System.out.println(breed + " не может столько проплыть");
    }
}




