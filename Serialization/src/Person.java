import java.io.Serializable;

public class Person implements Serializable {
    String name;

    public Person() {
        this.name = "Person";
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
