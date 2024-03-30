package ru.otus.cherepanovvs.lesson15;

public class CompanyStaff {
    private final String name;
    private int age;

    public CompanyStaff(String name, int currentAge) {
        this.name = name;
        this.age = currentAge;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return this.name + "_" + this.age;
    }
}
