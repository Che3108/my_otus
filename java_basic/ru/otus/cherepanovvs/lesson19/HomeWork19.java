package ru.otus.cherepanovvs.lesson19;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HomeWork19 {
    public static void main(String[] args) {
        // Константы рабочей папки и формата открываемых файлов
        final String workFolderPath = ".";
        final String fileTypeMask = ".txt";

        // создаем папку и сканер
        File folder = new File(workFolderPath);
        Scanner scanner = new Scanner(System.in);

        // отображаем пользователю список доступных файлов 
        System.out.println("Доступны следующие файлы:");
        File[] listFilesName = folder.listFiles((dir, name) -> name.endsWith(fileTypeMask));
        for (File file : listFilesName) {
            System.out.println("  " + file.getName());
        }

        // Просим пользователя либо ввести имя существуещего файла, либо имя нового файла 
        String userInput = "";
        while (!userInput.contains(fileTypeMask)) {
            System.out.println("Введите имя файл для модификации, или имя нового файла:");
            System.out.println("Формат ввода: <your_file>.txt");
            System.out.print("> ");
            userInput = scanner.next();
        }

        // записываем полученное от пользователя имя файла и очищаем переменную, полученную от пользователя
        String useFileName = userInput;
        userInput = "";

        // проверяем полученное имя файла на соответствие с тукищими файлами
        boolean containsFileNameFlag = false;
        for (File file : listFilesName) {
            if (useFileName.equals(file.getName())) {
                containsFileNameFlag = true;
                break;
            }
        }

        // если файла нет, то просим пользователя подтвердить создание нового файла
        // если отказ или любой другой символ, то закрываем программу полностью
        // и очищаем переменную за собой
        if (!containsFileNameFlag) {
            System.out.println("Создать новый файл с именем " + useFileName + "? [N/Y]");
            System.out.print("> ");
            userInput = scanner.next();
            if (!(userInput.equals("Y") || userInput.equals("y"))) {
                System.out.println("Делать больше нечего");
                System.exit(0);
            }
        }
        userInput = "";

        // создаем объект редактируемого файла и уведомляем пользователя, что включилось редактирование файла
        System.out.println("Редактируемый файл " + useFileName + ", для выхода набрать :qw");
        File workFile = new File(folder, useFileName);

        // если файл не новый, то прочитаем его содержимое и выведем в консоль
        if (workFile.exists()) {
            try (InputStreamReader in = new InputStreamReader(new FileInputStream(workFile.getPath()))) {
                int n = in.read();
                while (n != -1) {
                    System.out.print((char)n);
                    n = in.read();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Инициируем буферную переменную, в которой будем хранить введенные пользователем данные
        String inputUserData = "";

        // в бесконечном цикле получаем данные от пользователя
        while (true) {
            userInput = scanner.next();
            if (userInput.contains(":qw")) {
                break;
            }
            inputUserData += userInput + "\n";
        }

        // пишем буферную переменную в файл
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(workFile.getPath()))) {
            byte[] buffer = inputUserData.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();

    }
}



