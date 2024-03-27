import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams2 {

    public static void main(String[] args) {
        List<String> myList = Arrays.asList("Hello", "Good Bye", "You are welcome");
        String[] arr = new String[3];
        String[] arr1 = {"1","2","3","3"};
        System.out.println(arr1.length);
        System.out.println(arr.length);


        Stream<String> myStream = myList.stream();
        myStream.forEach(n -> System.out.print(n + " - "));
        System.out.println();
        myList.stream().forEach(n -> System.out.print(n + " = "));
        System.out.println();
        myList.stream().sorted().forEach(n -> System.out.print(n + " + "));
        System.out.println();

        myList
                .stream()
                .filter(n -> n.contains("oo"))
                .map(n -> n + " Bye")
                .forEach(System.out::println);

    }

}
