package ru.otus.cherepanovvs.lesson17;

public class MyQueue<T> {
    private MyLinkedList<T> contents;

    public MyQueue() {
        this.contents = new MyLinkedList<>();
    }

    public void offer(T data) {
        this.contents.addLast(data);
    }

    public T poll() throws Empty {
        if (this.contents.getSize() == 0) {
            throw new Empty("Очередь пуста");
        }
        T value = this.contents.getFirst();
        this.contents.remove(0);
        return value;
    }

    @Override
    public String toString() {
        return this.contents.toString();
    }
}

class Empty extends RuntimeException {
    public Empty(String var1) {
        super(var1);
    }
}
