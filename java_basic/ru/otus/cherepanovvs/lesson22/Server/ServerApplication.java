package ru.otus.cherepanovvs.lesson22.Server;

public class ServerApplication {
    public static void main(String[] args) {
        Server server = new Server(8189);
        server.start();
    }
}