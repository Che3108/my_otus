package ru.otus.cherepanovvs.lesson28;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HomeWork28 {
    public static void main(String[] args) {
        final String workFolderPath = ".";
        final String fileTypeMask = ".txt";

        File folder = new File(workFolderPath);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Доступны следующие файлы:");
        File[] listFilesName = folder.listFiles((dir, name) -> name.endsWith(fileTypeMask));
        for (File file : listFilesName) {
            System.out.println("  " + file.getName());
        }

        String useFileName = "";
        while (!useFileName.contains(fileTypeMask)) {
            System.out.println("Введите имя файл для модификации, или имя нового файла:");
            System.out.println("Формат ввода: <your_file>.txt");
            System.out.print("> ");
            useFileName = scanner.next();
        }

        boolean containsFileNameFlag = false;
        for (File file : listFilesName) {
            if (useFileName.equals(file.getName())) {
                containsFileNameFlag = true;
                break;
            }
        }

        if (!containsFileNameFlag) {
            System.out.println("Файл с таким именем не найден, делать больше нечего");
            System.exit(0);
        }

        System.out.println("Введите последовательность символов для поиска:");
        System.out.print("> ");
        String searchString = scanner.next();
        scanner.close();

        File workFile = new File(folder, useFileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(workFile.getPath()))) {
            String line;
            StringBuilder text = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                text.append(line);
            }
            int count = countOccurrences(text.toString(), searchString);
            System.out.println("В файле " + useFileName + " последовательность '" + searchString + "' встречается " + count + " раз(а).");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countOccurrences(String text, String searchString) {
        int count = 0;
        int index = 0;

        while (index != -1) {
            index = text.indexOf(searchString, index);
            if (index != -1) {
                count++;
                index += searchString.length();
            }
        }
        
        return count;
    }
}