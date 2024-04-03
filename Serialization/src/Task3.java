import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class Task3 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Character.getName(i));
        }
        serialObj(list, "output.txt");

//        ArrayList<String> list1 = null;
//        list1 = (ArrayList<String>) deserializeObj("output.txt");
        Object list1;
        list1 = deserializeObj("output.txt");
        System.out.println(list1);

    }

    public static void serialObj(Object object, String file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.close();
    }

    public static Object deserializeObj(String file) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return ois.readObject();
    }

}
