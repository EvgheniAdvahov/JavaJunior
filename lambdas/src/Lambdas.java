import java.awt.print.Printable;

/**
 * Lambda only with cerain type of interfaces
 */


public class Lambdas {

    public static void main(String[] args) {

        MyPrint a = (p,s) -> {
            System.out.println(p + " hello" + s);
            return null;
        };
        a.print("(^-^)", " Meow");
        MyMethod(a);
//
//        Runnable myRunnable = () -> System.out.println("hello from runnable");
//        myRunnable.run();
//
//        Thread thread = new Thread(myRunnable);
//        thread.start();


    }

    public static void MyMethod(MyPrint obj) {
        obj.print("(^-^)"," Meow");
    }


}
