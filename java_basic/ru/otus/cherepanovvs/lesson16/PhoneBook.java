package ru.otus.cherepanovvs.lesson16;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<String> phones = new ArrayList<>();
    private List<String> names = new ArrayList<>();

    public PhoneBook() {
    }

    public void add(String name, String phone) {
        if (this.phones.contains(phone)) {
            Integer indexPhone = this.phones.indexOf(phone);
            System.out.println("Телефонный номер не добавлен");
            System.out.println("Номер " + phone + " уже есть в справочнике и принадлежит " + this.names.get(indexPhone));
            return;
        }
        this.names.add(name);
        this.phones.add(phone);
        return;
    }

    public void find(String name) {
        if (!this.names.contains(name)) {
            System.out.println("Имя " + name + " отсутствует в справочнике");
            return;
        }
        System.out.println(name + ":");
        for (int i = 0; i < this.names.size(); i++) {
            if (name.equals(this.names.get(i))) {
                System.out.println("\t" + this.phones.get(i));
            }
        }
    }

    public void containsPhoneNumber(String phone) {
        if (this.phones.contains(phone)) {
            System.out.println("Номер " + phone + " есть в справочнике");
        } else {
            System.out.println("Номера " + phone + " нет в справочнике");
        }
    }
    
}
