package ru.otus.cherepanovvs.lesson27;

import java.util.ArrayList;

public class Box<F extends Fruit> {
    private int currWeight;
    private ArrayList<F> storage;

    public Box() {
        this.currWeight = 0;
        this.storage = new ArrayList<>();
    }

    public int weight() {
        return currWeight;
    }

    public boolean add(F fruit) {
        this.currWeight += fruit.getWeightOneUnit();
        storage.add(fruit);
        return true;
    }

    public boolean compare(Box<F> box) {
        if (this.currWeight == box.currWeight) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.storage.toString();
    }

    public boolean transferFruits(Box<? super F> otherBox) {
        otherBox.storage.addAll(this.storage);
        otherBox.currWeight += this.currWeight;
        this.storage.clear();
        this.currWeight = 0;
        return false;
    }
}
