package study.designpattern.strategypattern;

/**
 * Created by eguns on 2017. 4. 24..
 */
public class ConsoleLogging implements Logging {
    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
