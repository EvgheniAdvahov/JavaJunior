import java.io.*;

public class Main {

    public static void main(String[] args) {
        Person person = new Person();

        try{
            //поток записи байт в фаил
            FileOutputStream fos = new FileOutputStream("output.txt");
            //поток записи объекта в фаил
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //запись
            oos.writeObject(person);
            //закрываем поток
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (
                FileInputStream fis = new FileInputStream("output.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                )
        {
            Object var = ois.readObject();
            System.out.println(var);

        }catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}