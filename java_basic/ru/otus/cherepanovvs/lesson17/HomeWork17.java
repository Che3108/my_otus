package ru.otus.cherepanovvs.lesson17;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class HomeWork17 {
    public static void main(String[] args) {
        /*
        Написать свой класс MyLinkedList поддерживающий методы
        addFirst(T data) - добавляет элемент в начало списка, остальные сдвигаются вправо
        addLast(T data) - добавляет элемент в конец списка
        T getFirst() - возвращает первый элемент списка
        T getLast() - возвращает последний элемент списка
        add(int position, T data) - вставляет элемент на позицию с номером position, остальные элементы сдвигаются вправо
        T remove(int position) - удаляет элемент с номером position
        T get(int position) - возвращает элемент с номером posiion
        int getSize() - возвращает количество элементов в списке.
        */
        MyLinkedList<Integer> test_list = new MyLinkedList<>();

        // проверяем метод getSize
        System.out.println("Текущий размер: " + test_list.getSize());
        System.out.println("Текущее содержимое: " + test_list);
        System.out.println();

        // проверяем методы addFirst и addLast
        test_list.addFirst(1);
        test_list.addLast(2);
        test_list.addFirst(3);
        test_list.addLast(4);

        System.out.println("Текущий размер: " + test_list.getSize());
        System.out.println("Текущее содержимое: " + test_list);
        System.out.println();

        // проверяем метод add
        test_list.add(2, 15);
        test_list.add(3, 27);
        // если индекс больше или равен размеру листа, то будет исключение IndexOutOfBoundsException
        try {
            test_list.add(77, 77);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex);
            System.out.println();
        }
        System.out.println("Текущий размер: " + test_list.getSize());
        System.out.println("Текущее содержимое: " + test_list);
        System.out.println();

        // отрицательные индексы использовать нельзя
        try {
            test_list.add(-1, 37);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex);
            System.out.println();
        }

        System.out.println("Текущий размер: " + test_list.getSize());
        System.out.println("Текущее содержимое: " + test_list);
        System.out.println();

        // проверяем методы getFirst, getLast, get
        System.out.println("Первый элемент: " + test_list.getFirst());
        System.out.println("Последний элемент: " + test_list.getLast());
        System.out.println("Третий элемент: " + test_list.get(3));
        System.out.println();

        // если попытаться получить индекс, которого нет, то будет исключение IndexOutOfBoundsException
        try {
            System.out.println("Восьмой элемент: " + test_list.get(8));
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex);
            System.out.println();
        }

        // проверяем метод remove
        test_list.remove(2);
        System.out.println("Текущий размер: " + test_list.getSize());
        System.out.println("Текущее содержимое: " + test_list);
        System.out.println();

        test_list.remove(4);

        System.out.println("Текущий размер: " + test_list.getSize());
        System.out.println("Текущее содержимое: " + test_list);
        System.out.println();

        // если попытаться удалить индекс, которого нет, то будет исключение IndexOutOfBoundsException
        try {
            test_list.remove(8);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex);
            System.out.println();
        }


        /*
        На основе разработанного MyLinkedList создать класс MyQueue работающий по принципу очереди, и имеющий два метода
        offer(T data), добавляющий элемент в очередь и T poll() - забирающий элемент из очереди
        */
        MyQueue<Integer> queue = new MyQueue<>();
        System.out.println("Текущее содержимое очереди: " + queue);

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println("Текущее содержимое очереди: " + queue);

        System.out.println("Из очереди достали: " + queue.poll());
        System.out.println("Текущее содержимое очереди: " + queue);
        System.out.println("Из очереди достали: " + queue.poll());
        System.out.println("Текущее содержимое очереди: " + queue);
        System.out.println("Из очереди достали: " + queue.poll());
        System.out.println("Текущее содержимое очереди: " + queue);
        System.out.println();

        // если попытаться достать элемент из пустой очереди, то будет исключение
        try {
            System.out.println("Из очереди достали: " + queue.poll());
            System.out.println("Текущее содержимое очереди: " + queue);
        } catch (EmptyStackException ex) {
            System.out.println(ex);
            System.out.println();
        }
        

        /*
        На основе разработанного MyLinkedList построить класс MyStack имеющий два метода - 
        push(T data) - помещающий элемент в стек и T pop() - достающий элемент из стека
        */
        MyStack<Integer> stack = new MyStack<>();
        System.out.println("Текущее содержимое стека: " + stack);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Текущее содержимое стека: " + stack);

        System.out.println("Из стека достали: " + stack.pop());
        System.out.println("Текущее содержимое стека: " + stack);
        System.out.println("Из стека достали: " + stack.pop());
        System.out.println("Текущее содержимое стека: " + stack);
        System.out.println("Из стека достали: " + stack.pop());
        System.out.println("Текущее содержимое стека: " + stack);
        System.out.println();

        // если попытаться достать элемент из пустого стека, то будет исключение
        try {
            System.out.println("Из стека достали: " + stack.pop());
            System.out.println("Текущее содержимое стека: " + stack);
        } catch (EmptyStackException ex) {
            System.out.println(ex);
            System.out.println();
        }


        /*
        Написать функцию int[] sort(int[] array) - возвращающий отсортированный по возрастанию массив. 
        Готовыми методами сортировки не пользоваться - использовать алгоритм сортировки пузырьком
        */
        int[] myArray = new int[] {0, 1, 9, 2, 8, 3, 7, 4, 6, 5};
        System.out.println(Arrays.toString(myArray));
        int[] result = sort(myArray);
        System.out.println(Arrays.toString(result));
        System.out.println();


        /*
        ** В задании выше осуществить сортировку с помощью алгоритма quicksort или слиянием (сложность O(N log(N))
        */
        System.out.println(Arrays.toString(myArray));
        int[] result2 = quickSort(myArray, 0, myArray.length - 1);
        System.out.println(Arrays.toString(result2));
    }

    public static int[] sort(int[] array) {
        int[] result = array.clone();
        boolean stepFlag = true;
        while (stepFlag) {
            stepFlag = false;
            for (int i = 1; i < result.length; i++) {
                if (result[i - 1] > result[i]) {
                    int buffer = result[i - 1];
                    result[i - 1] = result[i];
                    result[i] = buffer;
                    stepFlag = true;
                }        
            }
        }
        return result;
    }


    static int[] quickSort(int[] array, int l, int h) {
        if (array == null || array.length == 0) {
            return null;
        }
        if (l >= h) {
            return null;
        }
        int[] result = array.clone();
        Stack<Integer> stack = new Stack<>();
        stack.push(l);
        stack.push(h);
        while (!stack.isEmpty()) {
            h = stack.pop();
            l = stack.pop();
            int pivotIndex = partition(result, l, h);
            if (pivotIndex - 1 > l) {
                stack.push(l);
                stack.push(pivotIndex - 1);
            }
            if (pivotIndex + 1 < h) {
                stack.push(pivotIndex + 1);
                stack.push(h);
            }
        }
        return result;
    }
 
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }
}
