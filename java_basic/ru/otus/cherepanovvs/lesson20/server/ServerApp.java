package ru.otus.cherepanovvs.lesson20.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ServerApp {
    public static void main(String[] args) {
        final int port = 8899;
        final String exitComand = ":q";
        try (ServerSocket socket = new ServerSocket(port, 3)) {
            System.out.println("Server start at port: " + port); 
            while (true) {
                Socket client = socket.accept();
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                Scanner in = new Scanner(client.getInputStream());
                if (client.isConnected()) {
                    System.out.println("Client is connected");
                    out.println("Вас приветствует сетевой калькулятор. Для работы введите число A, пробел, число B, пробел, операнд (+, -, * или /). Для выхода введите :q"); 
                }
                while (true) {
                    if (in.hasNext()) {
                        String clientData = in.nextLine();
                        System.out.println("client send: " + clientData);
                        if (clientData.equals(exitComand)) {
                            out.println(exitComand);
                            break;
                        }
                        String result = null;
                        try {
                            result = calculator(clientData);
                        } catch (InputMismatchException e) {
                            e.printStackTrace();
                            result = "Упс, что-то пошло не так. Попробуйте снова";
                        }
                        out.println("Ответ: " + result);
                    }
                }
                if (client.isClosed()) {
                    System.out.println("Client is disconnected");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String calculator(String arg) throws InputMismatchException {
        String[] args = arg.split(" ");
        if (args.length != 3) {
            throw new InputMismatchException();
        }
        String operand = args[2];
        Float A = null;
        Float B = null;
        Float result = 0.0f;
        try {
            A = Float.parseFloat(args[0]);
            B = Float.parseFloat(args[1]);
        } catch (NumberFormatException e) {
            throw new InputMismatchException(e.getMessage());
        }
        if ((A == null) || (B == null)) {
            throw new InputMismatchException();
        }
        if ((B.equals(0.0f)) & (operand.equals("/"))) {
            throw new InputMismatchException();
        }
        switch (operand) {
            case "+": result = A + B;
                break;
            case "-": result = A - B;
                break;
            case "*": result = A * B;
                break;
            case "/": result = A / B;
                break;
            default: throw new InputMismatchException();
        }
        return Float.toString(result);
    }
}
