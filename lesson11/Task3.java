package geekBrains.lesson11;

import java.util.ArrayList;

public class Task3 {

    public static void main(String[] args) {

        Apple oneA = new Apple(150);
        Apple twoA = new Apple(200);
        Apple threeA = new Apple(180);
        Apple fourA = new Apple(210);
        Orange oneO = new Orange(220);
        Orange twoO = new Orange(310);
        Box<Apple> applebox = new Box<Apple>();
        Box<Apple> applebox2 = new Box<Apple>();
        Box.addFruit(oneA, applebox);
        Box.addFruit(twoA, applebox);
        Box.addFruit(threeA, applebox2);
        Box.addFruit(fourA, applebox2);
        Box<Orange> orangebox = new Box<Orange>();
        Box.addFruit(oneO, orangebox);
        Box.addFruit(twoO, orangebox);

        //Проверочка что коробки создались
        System.out.println(applebox.size());

        for (Fruit F: orangebox) {
            System.out.println(F.getWeight());
        }

        //Вес коробки
        Box.boxWeight(applebox);

        //Сравнение коробок
        System.out.println(applebox.compareBox(orangebox));

        //Перенос фруктов по коробкам
        applebox.moveFruit(applebox2);
        System.out.println(applebox.size());
        System.out.println(applebox2.size());

    }
}


class Fruit {
    int weight;
    public int getWeight() {
        return weight;
    }

}

class Apple extends Fruit {
    int weight;

    public Apple (int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

}

class Orange extends Fruit {
    int weight;

    public Orange (int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}

class Box <T extends Fruit> extends ArrayList<T> {

    ArrayList<T> fruitbox;

    public static <T extends Fruit> void addFruit(T fruit, ArrayList<T> fruitbox) {
        fruitbox.add(fruit);
    }

    public static <T extends Fruit> int boxWeight(Box<T> list) {
        int totalWeight = 0;
        for (T t : list) {
            totalWeight += t.getWeight();
        }
        return totalWeight;
    }

    public boolean compareBox(Box<?> another) {
        if (Box.boxWeight(this) == Box.boxWeight(another)) {
            return true;
        } else {
            return false;
        }
    }

    public <T extends Fruit> void moveFruit(Box<T> list) {
        for (int x = this.size() - 1; x >= 0; x--) {
            list.add((T) this.get(x));
            this.remove(this.get(x));
        }
    }
}