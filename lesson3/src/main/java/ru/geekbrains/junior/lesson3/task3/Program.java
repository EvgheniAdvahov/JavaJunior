package ru.geekbrains.junior.lesson3.task3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class Program {

    public static void main(String[] args) {
        Student student = new Student("Evgheni", 36, 5);

        serializeToBin("file.txt", student);
        System.out.println(deserializeFromBin("file.txt"));

        serializeToJson("file.json", student);
        System.out.println(deserializeFromJson("file.json"));

        serializeToXml("file.xml", student);
        System.out.println(deserializeFromXml("file.xml"));


    }

    public static void serializeToBin(String file, Object object) {
        try (
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(object);
            System.out.println("Объект успешно сериализован в файл file.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object deserializeFromBin(String file) {
        try (
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            Object object;
            object = ois.readObject();
            System.out.println("Объект успешно десериализован из файла " + file);
            return object;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void serializeToJson(String file, Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(file), object);
            System.out.println("Объект успешно сериализован в файл " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserializeFromJson(String file) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Object object = objectMapper.readValue(new File(file), Object.class);
            System.out.println("Объект успешно десериализован из файла " + file);
            return object;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void serializeToXml(String file, Object object) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            xmlMapper.writeValue(new File(file), object);
            System.out.println("Объект успешно сериализован в файл " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserializeFromXml(String file) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            Object object = xmlMapper.readValue(new File(file), Object.class);
            System.out.println("Объект успешно десериализован из файла " + file);
            return object;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
