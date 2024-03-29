package ru.geekbrains.junior.lesson2.task4;

public class Cat extends Animal {

    private String color;

    public Cat() {
        super("Кузя", 2);
        this.color = "Белый";
    }

    public String printInfo(){
        return System.out.printf("Имя: %s; Возраст: %d; Цвет: %s\n", super.getName() , super.getAge(), color)
                .toString();
    }


}
