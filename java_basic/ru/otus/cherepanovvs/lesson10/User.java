package ru.otus.cherepanovvs.lesson10;

public class User {
    private String surname;
    private String name;
    private String patronymic;
    private String email;
    private int birthYear;

    public User(String surname, String name, String patronymic, int birthYear, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthYear = birthYear;
        this.email = email;
    }

    public void info() {
        System.out.println("ФИО: " + this.surname + " " + this.name + " " + this.patronymic);
        System.out.println("Год рождения: " + this.birthYear);
        System.out.println("Год рождения: " + this.email);
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public int getAge(int currYear) {
        int age = -1;
        if (currYear >= this.birthYear) {
            age = currYear - this.birthYear;
        }
        return age;
    }

}
