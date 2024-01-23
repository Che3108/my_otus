package ru.otus.cherepanovvs.lesson20.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {

        try (ServerSocket socket = new ServerSocket(8899)) {
            while (true) {
                Socket client = socket.accept();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

                    while (true) {
                        String str = reader.readLine();
                        if (str == null || str.trim().length() == 0) {
                            break;
                        }
                        System.out.println(str);
                    }
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
