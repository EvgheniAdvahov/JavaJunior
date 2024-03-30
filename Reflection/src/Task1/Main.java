package Task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {


    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {


        System.out.println("===============================");
        Cat cat1 = new Cat("Cuzea");
        Constructor<?>[] constructors = cat1.getClass().getConstructors();
        Object cat2 = constructors[0].newInstance("Dunica");

        Field[] fieldsCat2 = cat2.getClass().getFields();
        int tmp = fieldsCat2[fieldsCat2.length-1].getInt(cat2);
        fieldsCat2[fieldsCat2.length -1].setInt(cat2, tmp * 2);
        System.out.println(cat2);
        fieldsCat2[fieldsCat2.length -2].set(cat2, "New Name");
        System.out.println(cat2);
        fieldsCat2[fieldsCat2.length -1].set(cat2, 5);
        System.out.println(cat2);




//        Method[] methods = cat2.getClass().getDeclaredMethods();
//        System.out.println("methods.length = " + methods.length);
//        for (Method method : methods) {
//            System.out.println(method);
//        }
//        System.out.println(cat2);


    }


}