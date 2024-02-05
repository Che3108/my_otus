package ru.otus.cherepanovvs.lesson27;

public class HomeWork27 {
    public static void main(String[] args) {
        /*
        Создайте классы Fruit, Apple extends Fruit, Orange extends Fruit;
        Создайте класс Box, в который можно складывать фрукты.
        Коробки условно сортируются по типу фрукта:
            Box только для яблок,
            Box только для апельсин,
            Box и для тех, и для других фруктов.
            Для хранения фруктов внутри коробки используйте ArrayList;
        Реализуйте метод добавления фрукта в коробку;
        Реализуйте метод weight, который высчитывает вес коробки (например, из веса одного фрукта и их количества, или может через суммирование, как посчитаете нужным).
        Вес фрукта задаете самостоятельно, единицы измерения не важны;
        Реализуйте метод compare, позволяющий сравнить текущую коробку с переданной в качестве аргумента. true – если их массы равны. Можно сравнивать коробки с разными типами фруктов;
        Реализуйте метод, позволяющий пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов в коробках;
         */


        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();
        Box<Fruit> box3 = new Box<>();

        box1.add(new Apple());
        box2.add(new Orange());
        box3.add(new Orange());
        box3.add(new Apple());

        System.out.println("Исходное состояние");
        System.out.println("box1: " + box1.weight());
        System.out.println("box2: " + box2.weight());
        System.out.println("box3: " + box3.weight());
        System.out.println();

        // нельзя
        //box1.transferFruits(box2);
        //box2.transferFruits(box1);

        // можно
        box1.transferFruits(box3);
        box2.transferFruits(box3);

        System.out.println("Все ссыпали в box3");
        System.out.println("box1: " + box1.weight());
        System.out.println("box2: " + box2.weight());
        System.out.println("box3: " + box3.weight());


    }
    
}
