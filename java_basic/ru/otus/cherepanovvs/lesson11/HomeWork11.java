package ru.otus.cherepanovvs.lesson11;

import ru.otus.cherepanovvs.lesson11.Animal.Cat;
import ru.otus.cherepanovvs.lesson11.Animal.Dog;
import ru.otus.cherepanovvs.lesson11.Animal.Horse;

public class HomeWork11 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Мурзик");
        Dog dog1 = new Dog("Шарик");
        Horse horse1 = new Horse("Гром");

        cat1.info();
        dog1.info();
        horse1.info();

        int distanceRun = 250;
        int distanceSwim = 30;

        cat1.run(distanceRun);
        dog1.run(distanceRun);
        horse1.run(distanceRun);
        System.out.println();

        dog1.swim(distanceSwim);
        horse1.swim(distanceSwim);
        System.out.println();

        cat1.info();
        dog1.info();
        horse1.info();

    }
}


/*
Создайте классы Cat, Dog и Horse с наследованием от класса Animal
У каждого животного есть имя, скорость бега и плавания (м/с), и выносливость (измеряется в условных единицах)

Затраты выносливости:
Все животные на 1 метр бега тратят 1 ед выносливости,

Собаки на 1 метр плавания - 2 ед.
Лошади на 1 метр плавания тратят 4 единицы
Кот плавать не умеет.


Реализуйте методы run(int distance) и swim(int distance), которые должны возвращать время, затраченное на указанное действие, и “понижать выносливость” животного. 
Если выносливости не хватает, то возвращаем время -1 и указываем что у животного появилось состояние усталости. При выполнении действий пишем сообщения в консоль.

Добавьте метод info(), который выводит в консоль состояние животного.


 */