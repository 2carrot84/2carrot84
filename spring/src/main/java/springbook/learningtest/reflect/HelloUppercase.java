package springbook.learningtest.reflect;

/**
 * Created by eguns on 2017. 6. 20..
 */
// proxy class
public class HelloUppercase implements Hello {
    // 위임할 target object - interface로 접근
    Hello hello;

    public HelloUppercase(Hello hello) {
        this.hello = hello;
    }

    @Override
    public String sayHello(String name) {
        return hello.sayHello(name).toUpperCase();
    }

    @Override
    public String sayHi(String name) {
        return hello.sayHi(name).toUpperCase();
    }

    @Override
    public String sayThankyou(String name) {
        return hello.sayThankyou(name).toUpperCase();
    }

    @Override
    public String callName(String name) {
        return name;
    }
}
