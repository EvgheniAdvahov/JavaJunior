package org.example.Task2;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    private ServerSocket serverSocket;

    public MyServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }


    public void runServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                MyClientManager client = new MyClientManager(socket);
                Thread thread = new Thread(client);
                System.out.println("Подключён новый клиент! : " + client.getName());
                thread.start();
            }
        } catch (IOException e) {
            closeSocket();
        }
    }

    private void closeSocket() {
        try {
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1300);
        MyServer myServer = new MyServer(serverSocket);
        myServer.runServer();
    }

}
