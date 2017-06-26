package springbook.learningtest.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by eguns on 2017. 6. 20..
 */
public class ReflectTest {
    @Test
    public void reflectTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String name = "lee";
        Method method = String.class.getMethod("length");
        int length = (int)method.invoke(name);
        assertThat(length, is(3));
        assertThat(name.length(), is(3));
    }

    @Test
    public void simpleProxy() {
        Hello hello = new HelloTarget();
        assertThat(hello.sayHello("Lee"), is("Hello, Lee") );
        assertThat(hello.sayHi("Lee"), is("Hi, Lee") );
        assertThat(hello.sayThankyou("Lee"), is("Thank You, Lee") );

        Hello proxiedHello = new HelloUppercase(new HelloTarget());

        assertThat(proxiedHello.sayHello("Lee"), is("HELLO, LEE") );
        assertThat(proxiedHello.sayHi("Lee"), is("HI, LEE") );
        assertThat(proxiedHello.sayThankyou("Lee"), is("THANK YOU, LEE") );
        assertThat(proxiedHello.callName("Lee"), is("Lee") );

        Hello proxiedHandler = (Hello) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{Hello.class},   // 타깃 인터페이스
                new UppercaseHandler(new HelloTarget()) // 부가기능과 위임 코드 InvocationHandler 구현 클래스
        );

        assertThat(proxiedHandler.sayHello("Lee"), is("HELLO, LEE") );
        assertThat(proxiedHandler.sayHi("Lee"), is("HI, LEE") );
        assertThat(proxiedHandler.sayThankyou("Lee"), is("THANK YOU, LEE") );
        // 다이내믹 프록시에서 메소드 명이 say로 시작할경우만 적용 테스트
        assertThat(proxiedHandler.callName("Lee"), is("Lee") );



    }
}
