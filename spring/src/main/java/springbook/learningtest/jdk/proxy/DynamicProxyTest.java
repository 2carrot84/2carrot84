package springbook.learningtest.jdk.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import springbook.learningtest.jdk.Hello;
import springbook.learningtest.jdk.HelloTarget;
import springbook.learningtest.jdk.UppercaseHandler;

import java.lang.reflect.Proxy;

import static org.hamcrest.core.Is.is;

/**
 * Created by eguns on 2017. 4. 12..
 */
public class DynamicProxyTest {
    @Test
    public void simpleProxy() {
        Hello proxiedHello = (Hello) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[] { Hello.class},
                new UppercaseHandler(new HelloTarget())
        );

        Assert.assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
        Assert.assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
        Assert.assertThat(proxiedHello.sayThankyou("Toby"), is("THANK YOU TOBY"));

    }

    @Test
    public void proxyFactoryBean() {
        ProxyFactoryBean pfBean = new ProxyFactoryBean();
        pfBean.setTarget(new HelloTarget());
        pfBean.addAdvice(new UppercaseAdvice());

        Hello proxiedHello = (Hello) pfBean.getObject();

        Assert.assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
        Assert.assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
        Assert.assertThat(proxiedHello.sayThankyou("Toby"), is("THANK YOU TOBY"));

    }

    static class UppercaseAdvice implements MethodInterceptor {
        @Override
        public Object invoke(MethodInvocation methodInvocation) throws Throwable {
            String ret = (String)methodInvocation.proceed();
            return ret.toUpperCase();
        }
    }

    @Test
    public void pointcutAdvisor() {
        ProxyFactoryBean pfBean = new ProxyFactoryBean();
        pfBean.setTarget(new HelloTarget());

        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("sayH*");

        pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new UppercaseAdvice()));

        Hello proxiedHello = (Hello) pfBean.getObject();

        Assert.assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
        Assert.assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
        Assert.assertThat(proxiedHello.sayThankyou("Toby"), is("Thank You Toby"));

    }
}
