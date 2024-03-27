public class LambdaTeste2 {

    public static void main(String[] args) {
        MyPrint lambdaPrint = (p,s) -> p + "hello" + s;
        System.out.println(lambdaPrint.print("Prefix ", " Sufix"));
        System.out.println(printMyPrint(lambdaPrint));



    }
    public static String printMyPrint(MyPrint thing){
        return thing.print("Prefix ", " Sufix");
    }

}
