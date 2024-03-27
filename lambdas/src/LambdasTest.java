import java.util.function.Predicate;

public class LambdasTest {

    public static void main(String[] args) {
        Predicate<Integer> predi = (a) -> {
            if (a % 2 == 0) {
                System.out.println("even " + a);
            }else System.out.println("odd " + a);
            return false;
        };
        predi.test(6);
    }
}
