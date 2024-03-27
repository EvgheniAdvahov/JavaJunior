import java.util.Arrays;

public class LambdaTest3 {

    public static void main(String[] args) {
        MyInterface mySum = (x,y) -> x+y;
        System.out.println(mySum.sum(2, 3));
        System.out.println("==============");

        System.out.println(Arrays.asList("1", "2", "3", "4")
                .stream()
                .filter(str -> Integer.parseInt(str) % 2 == 0)
                .mapToInt(str -> Integer.valueOf(str))
                .sum());
    }

}
