package ru.otus.cherepanovvs.lesson10;

public class HomeWork10 {
    public static void main(String[] args) {
        /*
        Создайте класс Пользователь (User) с полями: фамилия, имя, отчество, год рождения, email;
        Реализуйте у класса конструктор, позволяющий заполнять эти поля при создании объекта;
        В классе Пользователь реализуйте метод, выводящий в консоль информацию о пользователе в виде:
        ФИО: фамилия имя отчество
        Год рождения: год рождения
        e-mail: email
        В методе main() Main класса создайте массив из 10 пользователей и заполните его объектами и 
        с помощью цикла выведите информацию только о пользователях старше 40 лет.
        */
        final int currYear = 2008;
        User[] users = {
            new User("Лукьяненко", "Сергей",    "Васильевич",    1968, "Lukyanenko@mymail.moon"),
            new User("Дивов",      "Олег",      "Игоревич",      1968, "Divov@mymail.moon"),
            new User("Громов",     "Александр", "Николаевич",    1959, "Gromov@mymail.moon"),
            new User("Логинов",    "Святослав", "Владимирович",  1951, "Loginov@mymail.moon"),
            new User("Рыбаков",    "Вячеслав",  "Михайлович",    1954, "Rybakov@mymail.moon"),
            new User("Успенский",  "Михаил",    "Глебович",      1950, "Uspenskij@mymail.moon"),
            new User("Лазарчук",   "Андрей",    "Геннадьевич",   1958, "Lazarchuk@mymail.moon"),
            new User("Перумов",    "Николай",   "Данилович",     1963, "Perumov@mymail.moon"),
            new User("Головачёв",  "Василий",   "Васильевич",    1948, "Golovachyov@mymail.moon"),
            new User("Каганов",    "Леонид",    "Александрович", 1972, "Kaganov@mymail.moon"),
        };
        for (User user : users) {
            if (currYear - user.getBirthYear() > 40) {
                user.info();
                System.out.println();
            }
        }
        System.out.println("\n");


        /*
        Попробуйте реализовать класс по его описания:
        объекты класса Коробка должны иметь размеры и цвет. 
        Коробку можно открывать и закрывать.
        Коробку можно перекрашивать.
        Изменить размер коробки после создания нельзя.
        У коробки должен быть метод, печатающий информацию о ней в консоль.
        В коробку можно складывать предмет (если в ней нет предмета),
        или выкидывать его оттуда (только если предмет в ней есть),
        только при условии что коробка открыта (предметом читаем просто строку).
        Выполнение методов должно сопровождаться выводом сообщений в консоль.
        */
        // Создаем коробку и вывводим информацию о ней
        Box myBox = new Box(10, 15, 20, "Бежевый");
        myBox.info();
        System.out.println();

        // Меняем цвет
        myBox.setColor("Красный");;
        System.out.println();

        // Пытаемся добавить предмет
        myBox.putItem("Яблоко");
        System.out.println();

        // Добавляем предмет
        myBox.open();
        myBox.putItem("Яблоко");
        myBox.close();
        System.out.println();

        // Пытаемся добавить еще предмет
        myBox.open();
        myBox.putItem("Апельсин");
        myBox.close();
        System.out.println();

        // Выводим информацию о коробке
        myBox.info();
        System.out.println();

        // Пытаемся взять предмет
        myBox.takeItem();
        System.out.println();

        // Берем предмет
        myBox.open();
        myBox.takeItem();
        myBox.close();
        System.out.println();

        // Выводим информацию о коробке
        myBox.info();
        System.out.println();
    }
}
