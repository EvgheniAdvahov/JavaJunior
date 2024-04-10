package org.example.Task2;

import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        String message = "@user123";

        System.out.println(extractRecipient(message));


    }

    private static String extractRecipient(String message) {
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


//    private void broadcastMessage(String messageToSend) {
//        for (MyClientManager client : clients) {
//            try {
//                // Определяем получателя сообщения
//                String recipient = extractRecipient(messageToSend);
//
//                if (recipient != null && client.name.equals(recipient)) {
////                    // Если текущий клиент является получателем, отправляем ему сообщение
////                    client.bufferedWriter.write(messageToSend);
////                    client.bufferedWriter.newLine();
////                    client.bufferedWriter.flush();
//                } else if (recipient == null) {
//                    // Если сообщение не адресовано конкретному клиенту, отправляем его всем кроме отправителя
//                    if (!client.name.equals(name)) {
//                        client.bufferedWriter.write(messageToSend);
//                        client.bufferedWriter.newLine();
//                        client.bufferedWriter.flush();
//                    }
//                }
//            } catch (IOException e) {
//                closeEverything(socket, bufferedReader, bufferedWriter);
//            }
//        }
//    }
//
//    // Метод для извлечения имени клиента из сообщения
//    private String extractRecipient(String message) {
//        if (message.startsWith("@")) {
//            int indexOfSpace = message.indexOf(" ");
//            if (indexOfSpace != -1) {
//                return message.substring(1, indexOfSpace);
//            } else {
//                return message.substring(1);
//            }
//        }
//        return null;
//    }

}
