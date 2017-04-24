package springbook.learningtest.jdk.proxy;

import static org.hamcrest.core.Is.is;

import java.lang.reflect.Proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import springbook.learningtest.jdk.Hello;
import springbook.learningtest.jdk.HelloTarget;
import springbook.learningtest.jdk.UppercaseHandler;
import springbook.learningtest.spring.pointcut.Bean;
import springbook.learningtest.spring.pointcut.Target;

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
    
    @Test
	public void classNamePointcutAdvisor() {
		NameMatchMethodPointcut classMethodPointcut = new NameMatchMethodPointcut() {
			public ClassFilter getClassFilter() {
				return new ClassFilter() {
					@Override
					public boolean matches(Class<?> clazz) {
						// TODO Auto-generated method stub
						return clazz.getSimpleName().startsWith("HelloT");
					}
				};
			}
		};
		classMethodPointcut.setMappedName("sayH*");
		
		checkAdviced(new HelloTarget(), classMethodPointcut, true);
		
		class HelloWorld extends HelloTarget {};
		checkAdviced(new HelloWorld(), classMethodPointcut, false);
		
		class HelloToday extends HelloTarget {};
		checkAdviced(new HelloToday(), classMethodPointcut, true);
		
	}
	
	private void checkAdviced(Object target, Pointcut pointcut, boolean adviced) {
		ProxyFactoryBean pfBean = new ProxyFactoryBean();
		pfBean.setTarget(target);
		pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new UppercaseAdvice()));
		Hello proxiedHello = (Hello)pfBean.getObject();
		
		if(adviced) {
			Assert.assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
			Assert.assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
			Assert.assertThat(proxiedHello.sayThankyou("Toby"), is("Thank You Toby"));
		}
		else {
			Assert.assertThat(proxiedHello.sayHello("Toby"), is("Hello Toby"));
			Assert.assertThat(proxiedHello.sayHi("Toby"), is("Hi Toby"));
			Assert.assertThat(proxiedHello.sayThankyou("Toby"), is("Thank You Toby"));
		}
	}
	
	@Test
	public void methodSignaturePointcut() throws NoSuchMethodException, SecurityException {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(public int springbook.learningtest.spring.pointcut.Target.minus(int,int) throws java.lang.RuntimeException)");
		
		Assert.assertThat(pointcut.getClassFilter().matches(Target.class) &&
				pointcut.getMethodMatcher().matches(Target.class.getMethod("minus", int.class, int.class), null), is(true));
		
		Assert.assertThat(pointcut.getClassFilter().matches(Target.class) &&
				pointcut.getMethodMatcher().matches(Target.class.getMethod("plus", int.class, int.class), null), is(false));
		
		Assert.assertThat(pointcut.getClassFilter().matches(Target.class) &&
				pointcut.getMethodMatcher().matches(Target.class.getMethod("method"), null), is(false));
		
		AspectJExpressionPointcut pointcut1 = new AspectJExpressionPointcut();
		pointcut1.setExpression("execution(int *(int,int))");
		
		Assert.assertThat(pointcut1.getClassFilter().matches(Target.class) &&
				pointcut1.getMethodMatcher().matches(Target.class.getMethod("minus", int.class, int.class), null), is(true));
		
		Assert.assertThat(pointcut1.getClassFilter().matches(Target.class) &&
				pointcut1.getMethodMatcher().matches(Target.class.getMethod("plus", int.class, int.class), null), is(true));
		
		Assert.assertThat(pointcut1.getClassFilter().matches(Target.class) &&
				pointcut1.getMethodMatcher().matches(Target.class.getMethod("method"), null), is(false));
	}
	
	public void pointcutMatches(String expression, Boolean expected, Class<?> claxx, String methodName, Class<?>...args) throws Exception {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		
		pointcut.setExpression(expression);
		
		Assert.assertThat(pointcut.getClassFilter().matches(claxx) &&
				pointcut.getMethodMatcher().matches(claxx.getMethod(methodName, args), null), is(expected));
	}
	
	public void targetClassPointcutMatches(String expression, boolean...expected) throws Exception {
		pointcutMatches(expression, expected[0], Target.class, "hello");
		pointcutMatches(expression, expected[1], Target.class, "hello", String.class);
		pointcutMatches(expression, expected[2], Target.class, "plus", int.class, int.class);
		pointcutMatches(expression, expected[3], Target.class, "minus", int.class, int.class);
		pointcutMatches(expression, expected[4], Target.class, "method");
		pointcutMatches(expression, expected[5], Bean.class, "method");
	}
	
	@Test
	public void pointcut() throws Exception {
		targetClassPointcutMatches("execution(* *(..))", true, true, true, true, true, true);
	}
}