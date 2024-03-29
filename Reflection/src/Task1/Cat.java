package Task1;

import Task1.Animal;

public class Cat extends Animal {
    public String name;
    private String price;
    private String type;
    public int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat(String name) {
        this.name = name;
        this.type = "Britain";
        this.price = "100";
        this.age = 2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
