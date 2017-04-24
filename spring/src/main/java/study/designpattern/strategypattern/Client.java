package study.designpattern.strategypattern;

/**
 * Created by eguns on 2017. 4. 24..
 */
public class Client {
    private final Logging logging;

    public Client(Logging logging) {
        this.logging = logging;
    }

    public void doWork(final int count) {
        if(count % 2 == 0) {
            logging.write("Even number : " + count);
        }
    }
}
