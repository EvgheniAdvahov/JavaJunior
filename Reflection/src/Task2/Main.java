package Task2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Tiger tiger = new Tiger("Risea", 5);
        Field[] tigerFields = tiger.getClass().getDeclaredFields();


        for (Field tigerField : tigerFields) {
            if (tigerField.getName().equals("name")) {
                System.out.println(tigerField.isAccessible());
                tigerField.setAccessible(true);
                System.out.println(tigerField.isAccessible());
                tigerField.set(tiger, "John Doe");
            }
        }
        System.out.println(tiger.getName());

        Method[] methods = tiger.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals("thisIsAPrivateStatic")) {
                method.setAccessible(true);
                method.invoke(null);


            }
        }
    }

}
