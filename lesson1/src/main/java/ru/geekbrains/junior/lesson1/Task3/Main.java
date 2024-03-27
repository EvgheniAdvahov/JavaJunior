package ru.geekbrains.junior.lesson1.Task3;

import java.util.Arrays;
import java.util.List;

/*
 * Напишите программу, которая использует Stream API для обработки списка чисел.
 *  Программа должна вывести на экран среднее значение всех четных чисел
 * в списке.
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1,2,3,4,5,8);

        System.out.println(myList.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n)
                .average()
                .orElse(0.0));

        boolean test = false;
        System.out.println(test);
        if(!test) {
            System.out.println("false");

        }
    }

}
