package ru.geekbrains.junior.lesson2.task4;

public class Dog extends Animal{
    private String type;

    public Dog() {
        super("Шарик",3);
        this.type = "Овчарка";
    }



    private void makeSound() {
        System.out.println("Гав Гав Гав");
    }

    public String printInfo(){
        return System.out.printf("Имя: %s; Возраст: %d; Порода: %s\n", super.getName() , super.getAge(), type)
                .toString();
    }

}
