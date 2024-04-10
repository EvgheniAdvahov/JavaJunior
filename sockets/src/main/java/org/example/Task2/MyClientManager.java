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

    private void broadcastMessage(String messageToSend) {
        for (MyClientManager client : clients) {
            try {
                // Определяем получателя сообщения
                String recipient = extractRecipient(messageToSend);

                // Если сообщение начинается с символа "@" и клиент является получателем
                if (recipient != null && recipient.equals(client.name)) {
                    client.bufferedWriter.write(messageToSend);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }
                // Если сообщение не адресовано конкретному клиенту, отправляем его всем кроме отправителя
                else if (recipient == null && !client.name.equals(name)) {
                    client.bufferedWriter.write(messageToSend);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    // Метод для извлечения имени клиента из сообщения
    private String extractRecipient(String message) {
        int colonIndex = message.indexOf(":");
        if (colonIndex != -1) {
            String recipientPart = message.substring(colonIndex + 1).trim(); // Получаем часть строки после ":"
            if (recipientPart.startsWith("@")) {
                int indexOfSpace = recipientPart.indexOf(" "); // Ищем индекс пробела
                if (indexOfSpace != -1) {
                    return recipientPart.substring(1, indexOfSpace); // Возвращаем часть после "@", до пробела
                } else {
                    return recipientPart.substring(1); // Возвращаем часть после "@"
                }
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
