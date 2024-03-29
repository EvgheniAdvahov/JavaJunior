//import java.util.ArrayList;
//import java.util.Collection;
//
//public class Zoo {
//
//   private final Collection<Animal> animalCollection;
//
//
//    public Zoo(){
//        animalCollection = new ArrayList<>();
//    }
//
//    public void initializeZoo(){
//        animalCollection.add(new Cat());
//        animalCollection.add(new Dog());
//    }
//
//    public <T extends Animal> void printAnimal(Class<T> clazz){
//        for (Animal animal : animalCollection) {
//            if(clazz.isInstance(animal)){
//                System.out.println(animal.getName());
//            }
//        }
//    }
//
//
//}
