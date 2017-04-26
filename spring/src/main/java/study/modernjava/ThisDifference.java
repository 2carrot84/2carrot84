package study.modernjava;

/**
 * Created by eguns on 2017. 4. 26..
 */
public class ThisDifference {
    public static void main(String[] args) {
        ThisDifference test = new ThisDifference();

        test.print();
    }

    public void print() {
        Runnable anonClass = new Runnable() {
            @Override
            public void run() {
                verifyRunnable(this);
            }
        };

        anonClass.run();

        Runnable lambda = () -> verifyRunnable(this);
        lambda.run();
    }

    private void verifyRunnable(Object object) {
        System.out.println(object instanceof Runnable);
    }
}
