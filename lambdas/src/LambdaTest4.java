import java.util.Locale;
import java.util.stream.Stream;

public class LambdaTest4 {

    public static void main(String[] args) {
        MyInterface myInterface = Integer::sum;
        System.out.println(myInterface.sum(5, 3));

        Stream<String> myStream = Stream.of("Hello", "World", "Good buy", "!");
//        myStream.forEach(System.out::print);
        System.out.println();
        System.out.println(myStream);
        myStream
                .map(str -> str.toUpperCase(Locale.ROOT))
                .filter(str -> str.contains("O"))
                .forEach(str -> System.out.println(str + " "));
    }


}
