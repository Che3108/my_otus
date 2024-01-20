package ru.otus.cherepanovvs.lesson16;


public class HomeWork16 {
    public static void main(String[] args) {
        /*
        Реализуйте класс PhoneBook, который хранит в себе список имен (фио) и телефонных номеров;
        Метод add() должен позволять добавлять запись имя-телефон;
        Метод find() выполнять поиск номер(-а, -ов) телефона по имени;
        Под одним именем может быть несколько телефонов (в случае однофамильцев, или наличии у одного человека нескольких номеров),
        тогда при запросе такой фамилии должны выводиться все телефоны;
        Метод containsPhoneNumber должен проверять наличие телефона в справочнике.
        */

        PhoneBook myBook = new PhoneBook();

        myBook.add("Боб", "+79999999999");
        myBook.add("Боб", "+78888888888");
        myBook.add("Петр", "+71111111111");
        myBook.add("Влад", "+71111111111");

        myBook.find("Боб");
        myBook.find("Костя");

        myBook.containsPhoneNumber("+71111111111");
        myBook.containsPhoneNumber("+72222222222");
        
    }
}
