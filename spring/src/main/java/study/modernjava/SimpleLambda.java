package study.modernjava;

/**
 * Created by eguns on 2017. 4. 26..
 */
public class SimpleLambda {
    public static void main(String[] args) {
        Runnable lambda = ()-> System.out.println(1);
        lambda.run();
    }
}
