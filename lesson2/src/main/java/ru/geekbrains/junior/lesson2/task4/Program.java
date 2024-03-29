package ru.geekbrains.junior.lesson2.task4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Class<?> Cat = ru.geekbrains.junior.lesson2.task4.Cat.class;
        Class<?> Dog = ru.geekbrains.junior.lesson2.task4.Dog.class;

        Constructor<?>[] constructorCat = Cat.getConstructors();
        Constructor<?>[] constructorDog = Dog.getConstructors();

        Object catObject = constructorCat[0].newInstance();
        Object dogObject = constructorDog[0].newInstance();

        ArrayList<Animal> animalList = new ArrayList<>();
        animalList.add((Animal) catObject);
        animalList.add((Animal) dogObject);


        for (Animal animal : animalList) {
            try{
                Method method1 = animal.getClass().getDeclaredMethod("printInfo");
                method1.setAccessible(true);
                method1.invoke(animal);
            }catch (NoSuchMethodException e) {
                System.out.println("Метод printInfo() не найден в классе " + animal.getClass().getSimpleName());
            }

            try{
                Method method = animal.getClass().getDeclaredMethod("makeSound");
                method.setAccessible(true);
                method.invoke(animal);
            } catch (NoSuchMethodException e) {
                System.out.println("Метод makeSound() не найден в классе " + animal.getClass().getSimpleName());
            }
        }




    }

}
