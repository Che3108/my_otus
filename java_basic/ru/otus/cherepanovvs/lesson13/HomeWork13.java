package ru.otus.cherepanovvs.lesson13;

import ru.otus.cherepanovvs.lesson13.RidingAnimals.Horse;
import ru.otus.cherepanovvs.lesson13.Transport.Bicycle;
import ru.otus.cherepanovvs.lesson13.Transport.Car;
import ru.otus.cherepanovvs.lesson13.Transport.Offroader;


public class HomeWork13 {
    public static void main(String[] args) {
        /*
        Создайте класс Человек с полями name (имя) и currentTransport (текущий транспорт)
        Реализуйте в вашем приложении классы Машина, Лошадь, Велосипед, Вездеход
        Каждый из классов должен предоставлять возможность перемещаться на определенное расстояние с указанием типа местности
        В приложении должны быть типы местности: густой лес, равнина, болото
        Человек должен иметь возможность сесть на любой из этих видов транспорта, встать с него, или переместиться на некоторое расстояние (при условии что он находится на каком-либо транспорте)
        При попытке выполнить перемещение у человека, не использующего транспорт, считаем что он просто идет указанное расстояние пешком
        При перемещении Машина и Вездеход тратят бензин, который у них ограничен. Лошадь тратит силы. Велосипед может использоваться без ограничений (можете для усложнения велосипедом тратить силы “водителя”). При выполнении действия результат должен быть отпечатан в консоль
        У каждого вида транспорта есть местности по которым он не может перемещаться: машина - густой лес и болото, лошадь и велосипед - болото, вездеход - нет ограничений
        При попытке переместиться должен быть возвращен результат true/false - удалось ли выполнить действие
         */

        Human me = new Human("Боб", 1000, 2);
        Car car = new Car("Ford", 4000, 5, new Terrain[]{Terrain.PLAIN});
        Bicycle bike = new Bicycle("Bibi", new Terrain[]{Terrain.FOREST, Terrain.PLAIN});
        Offroader jeep = new Offroader("Willys", 8000, 14, new Terrain[]{Terrain.FOREST, Terrain.PLAIN, Terrain.SWAMP});
        Horse horse = new Horse("Mike", 2000, 16, new Terrain[]{Terrain.FOREST, Terrain.PLAIN});

        // Пройдем пешком по лесу
        me.info();
        me.drive(10, Terrain.FOREST);
        me.info();
        
        // Увидели, что стоит машина
        car.info();

        // сядем за руль машины
        me.takeTransport(car);
        me.drive(100, Terrain.PLAIN);
        me.drive(20, Terrain.SWAMP);
        car.info();

        // Увидели, что стоит джип
        jeep.info();

        // сядем за руль джипа
        me.takeTransport(jeep);
        me.drive(100, Terrain.SWAMP);
        me.drive(20, Terrain.FOREST);
        me.drive(200, Terrain.PLAIN);
        jeep.info();

        // Увидели, что стоит велосипед
        bike.info();

        // сядем за руль велосипеда
        me.takeTransport(bike);
        me.drive(50, Terrain.FOREST);
        me.drive(200, Terrain.PLAIN);
        bike.info();

        // Увидели, что стоит лошадь
        horse.info();

        // сядем на лошадь
        me.takeTransport(horse);
        me.drive(200, Terrain.PLAIN);
        me.drive(100, Terrain.SWAMP);
        me.drive(50, Terrain.FOREST);
        horse.info();

        // еще прогуляемся по лесу спешившись
        me.leaveTransport();
        me.drive(100, Terrain.FOREST);
        me.info();

        
    }
}
