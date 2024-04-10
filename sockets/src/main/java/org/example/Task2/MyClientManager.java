package org.example.Task2;


import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class MyClientManager implements Runnable {

    public static ArrayList<MyClientManager> clients = new ArrayList<>();
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;

    public MyClientManager(Socket socket) {
        try {
            this.socket = socket;
            bufferedWriter = new BufferedWriter(new
                    OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            broadcastMessage("Server: " + name + " подключился к чату");
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run() {
        String messageFromClient;
        while (socket.isConnected()) {
            try {
                messageFromClient = bufferedReader.readLine();
                broadcastMessage(messageFromClient);
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    private synchronized void broadcastMessage(String messageToSend) {
        for (MyClientManager client : clients) {
            try {
                // Определяем получателя сообщения
                String recipient = extractRecipient(messageToSend);
                // Если сообщение не адресовано конкретному клиенту, отправляем его всем кроме отправителя
                if (!client.name.equals(name)) {
                        client.bufferedWriter.write(messageToSend + recipient);
                        client.bufferedWriter.newLine();
                        client.bufferedWriter.flush();
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    // Метод для извлечения имени клиента из сообщения
    private synchronized String extractRecipient(String message) {
        if (message.startsWith("@")) {
            int indexOfSpace = message.indexOf(" ");
            if (indexOfSpace != -1) {
                return message.substring(1, indexOfSpace);
            } else {
                return message.substring(1);
            }
        }
        return null;
    }
    private void closeEverything(Socket socket, BufferedReader bufferedReader,
                                 BufferedWriter bufferedWriter) {
        removeClient();
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeClient() {
        clients.remove(this);
        broadcastMessage("SERVER: " + name + "покинул чат.");
    }


}
