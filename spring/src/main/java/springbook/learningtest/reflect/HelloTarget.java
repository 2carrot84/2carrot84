package springbook.learningtest.reflect;

/**
 * Created by eguns on 2017. 6. 20..
 */
public class HelloTarget implements Hello {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    @Override
    public String sayHi(String name) {
        return "Hi, " + name;
    }

    @Override
    public String sayThankyou(String name) {
        return "Thank You, " + name;
    }

    @Override
    public String callName(String name) {
        return name;
    }
}
