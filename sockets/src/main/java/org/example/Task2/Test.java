package org.example.Task2;

import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        String message = "user: @user123 message";

        System.out.println(extractRecipient(message));


    }

    private static String extractRecipient(String message) {
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

    private static String extractRecipientMessage(String message) {
        int colonIndex = message.indexOf(" ");
        if (colonIndex != -1) {
            String recipientPart = message.substring(colonIndex + 1).trim(); // Получаем часть строки после ":"
            String recipientPart = recipientPart.substring()


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




}
