package ru.otus.cherepanovvs.lesson20.client;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class ClientApp {
    public static void main(String[] args) {
        String mess = "hello!";
        try (Socket socket = new Socket("localhost", 8899)) {
            try (BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream())) {
                byte[] buffer = mess.getBytes(StandardCharsets.UTF_8);
                for (int i = 0; i < buffer.length; i++) {
                    out.write(buffer[i]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
