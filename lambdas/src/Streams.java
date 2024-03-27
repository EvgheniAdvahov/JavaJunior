import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(5, 2, 10, 0);



        myList.stream()
                .map(n -> n % 2 == 0 ? n * 2 : n * 3)
//                .sorted()
                .forEach(System.out::println);






    }


}
