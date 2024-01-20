package ru.otus.cherepanovvs.lesson15;

import java.util.ArrayList;
import java.util.List;

public class HomeWork15 {
    public static void main(String[] args) {
        /*
            1) Реализуйте метод, принимающий в качестве аргументов числа min и max, 
            и возвращающий ArrayList с набором последовательных значений в указанном диапазоне (min и max включительно, шаг - 1);
        */
        System.out.println(generateArrayList(-10, 20));


        /*
            2) Реализуйте метод, принимающий в качестве аргумента список целых чисел, 
            суммирующий все элементы, значение которых больше 5, и возвращающий сумму;
        */
        int sum = 0;
        List<Integer> newList = new ArrayList<>();
        try {
            sum = summator(newList);
            System.out.println(sum);
        } catch (EmptyInputListException e) {
            System.out.println(e.getMessage());
        } catch (NothingSummarizeException e) {
            System.out.println(e.getMessage());
        }

        newList.add(1);
        newList.add(3);
        newList.add(-1);

        try {
            sum = summator(newList);
            System.out.println(sum);
        } catch (NothingSummarizeException e) {
            System.out.println(e.getMessage());
        }

        newList.add(10);
        newList.add(15);
        sum = summator(newList);
        System.out.println(sum);


        /*
            3) Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, 
            метод должен переписать каждую заполненную ячейку списка указанным числом;
        */
        fillList(3, newList);
        System.out.println(newList);


        /*
            4) Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, 
            увеличивающий каждый элемент списка на указанное число;
        */
        increaseList(3, newList);
        System.out.println(newList);


        /*
            5) Создайте класс Сотрудник с полями: имя, возраст;
        */
        List<CompanyStaff> team = new ArrayList<>();
        team.add(new CompanyStaff("Bob", 29));
        team.add(new CompanyStaff("Stive", 37));
        team.add(new CompanyStaff("Jean", 33));
        team.add(new CompanyStaff("Morgan", 27));


        /*
            6) Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
        */
        List<String> names = getNameMembersTeam(team);
        System.out.println(names);


        /*
            7) Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст, 
            и возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу;
        */
        List<CompanyStaff> membersTeam = getAgeMoreThreshold(30, team);
        System.out.println(membersTeam);


        /*
            8) Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст, 
            и проверяющий что средний возраст сотрудников превышает указанный аргумент;
        */
        boolean signal = isMeanAgeMoreThreshold(30.0f, team);
        System.out.println(signal);
        

        /*
            9) Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку на самого молодого сотрудника.
        */
        CompanyStaff youngMemberTeam = getYoungMemberTeam(team);
        System.out.println(youngMemberTeam);
    }

    public static ArrayList<Integer> generateArrayList(int min, int max) throws MinOverMaxException {
        if (min > max) {
            throw new MinOverMaxException(min + " > " + max);
        }
        ArrayList <Integer> result = new ArrayList<>(max - min);
        for (int value = min; value <= max; value++) {
            result.add(value);
        }
        return result;
    }

    public static int summator(List<Integer> inputList) throws EmptyInputListException, NothingSummarizeException {
        if (inputList.size() == 0) {
            throw new EmptyInputListException("Пустой входящий список");
        }
        int summ = 0;
        for (Integer value : inputList) {
            if (value > 5) {
                summ += value;
            }
        }
        if (summ == 0) {
            throw new NothingSummarizeException("Отсутствуют подходящие элементы в списке");
        }
        return summ;
    }

    public static List<Integer> fillList(int fillValue, List<Integer> inputList) {
        // тут вместо цикла использовал replaceAll и lambda функцию
        inputList.replaceAll(e -> fillValue);
        
        // а это с циклом
        /*
        for (int i = 0; i < inputList.size(); i++) {
            inputList.set(i, fillValue);
        }
        */
        return inputList;
    }

    public static List<Integer> increaseList(int scale, List<Integer> inputList) {
        // снова использовал replaceAll и lambda функцию
        inputList.replaceAll(e -> e * scale);
        return inputList;
    }

    public static List<String> getNameMembersTeam(List<CompanyStaff> team) {
        List<String> names = new ArrayList<>();
        for (CompanyStaff memberTeam : team) {
            names.add(memberTeam.getName());
        }
        return names;
    }

    public static List<CompanyStaff> getAgeMoreThreshold(int threshold, List<CompanyStaff> team) {
        List<CompanyStaff> membersTeam = new ArrayList<>();
        for (CompanyStaff memberTeam : team) {
            if (memberTeam.getAge() >= threshold) {
                membersTeam.add(memberTeam);
            }
        }
        return membersTeam;
    }

    public static boolean isMeanAgeMoreThreshold(float minMeanAge, List<CompanyStaff> team) {
        boolean result = false;
        float realMeanAge = 0.0f;
        int summ = 0;
        for (CompanyStaff memberTeam : team) {
            summ += memberTeam.getAge();
        }
        // А правильно ли я нашел среднее?
        realMeanAge = (float) summ / (float) team.size();
        if (realMeanAge > minMeanAge) {
            result = true;
        }
        return result;
    }

    public static CompanyStaff getYoungMemberTeam(List<CompanyStaff> team) {
        int minAgeIndex = 0;
        int minAge = team.get(minAgeIndex).getAge();
        for (int i = 1; i < team.size(); i++) {
            if (minAge > team.get(i).getAge()) {
                minAge = team.get(i).getAge();
                minAgeIndex = i;
            }
        }
        return team.get(minAgeIndex);
    }
}

class MinOverMaxException extends RuntimeException {
    public MinOverMaxException(String var1) {
       super(var1);
    }
}

class EmptyInputListException extends RuntimeException {
    public EmptyInputListException(String var1) {
        super(var1);
    }
}

class NothingSummarizeException extends RuntimeException {
    public NothingSummarizeException(String var1) {
        super(var1);
    }
}
