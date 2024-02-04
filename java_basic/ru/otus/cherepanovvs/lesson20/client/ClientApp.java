package ru.otus.cherepanovvs.lesson20.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
        final String host = "127.0.0.1";
        final int port = 8899;
        final String exitComand = ":q";
        try (Socket socket = new Socket(host, port)) {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            Scanner readServer = new Scanner(socket.getInputStream());
            Scanner readConsole = new Scanner(System.in);
            while (true) {
                if (readServer.hasNext()) {
                    String serverData = readServer.nextLine();
                    if (serverData.equals(exitComand)) {
                        System.out.println("quit command ...");
                        readServer.close();
                        readConsole.close();
                        writer.close();
                        socket.close();
                        System.exit(0);
                    }
                    System.out.println(serverData);
                }
                String fromUser = readConsole.nextLine();
                writer.println(fromUser);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
