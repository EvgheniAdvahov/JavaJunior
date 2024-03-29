package Task2;

public class Tiger {

    private final String name;
    private int age;

    public Tiger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void meow(){
        System.out.println("MeoW !!!!!!!!!!!!!!!!!!!!!!!");
    }

    private void heyThisIsPrivate(){
        System.out.println("How did you call this private method");
    }

    public static void thisIsAPublicStatic(){
        System.out.println("I'm public and static");
    }

    private static void thisIsAPrivateStatic(){
        System.out.println("I'm private and static");
    }
}
