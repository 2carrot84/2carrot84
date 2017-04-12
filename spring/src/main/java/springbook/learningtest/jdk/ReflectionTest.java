package springbook.learningtest.jdk;

import static org.hamcrest.core.Is.is;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Assert;
import org.junit.Test;

public class ReflectionTest {
	@Test
	public void invokeMethod() throws Exception {
		String name = "Spring";
		
		Assert.assertThat(name.length(), is(6));
		
		Method lengthMethod = String.class.getMethod("length");
		Assert.assertThat((Integer)lengthMethod.invoke(name), is(6));
		
		Assert.assertThat(name.charAt(0), is('S'));
		
		Method charAtMethod = String.class.getMethod("charAt", int.class);
		Assert.assertThat((Character)charAtMethod.invoke(name, 0), is('S'));
	}
	
	@Test
	public void simpleProxy() {
		Hello hello = new HelloTarget();
		Assert.assertThat(hello.sayHello("Toby"), is("Hello Toby"));
		Assert.assertThat(hello.sayHi("Toby"), is("Hi Toby"));
		Assert.assertThat(hello.sayThankyou("Toby"), is("Thank You Toby"));

		Hello proxiedHello = new HelloUppercase(new HelloTarget());
		Assert.assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
		Assert.assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
		Assert.assertThat(proxiedHello.sayThankyou("Toby"), is("THANK YOU TOBY"));
		
		Hello proxiedHello2 = (Hello)Proxy.newProxyInstance(
				getClass().getClassLoader(),
				new Class[] { Hello.class },
				new UppercaseHandler(new HelloTarget()));
		
		Assert.assertThat(proxiedHello2.sayHello("Toby"), is("HELLO TOBY"));
		Assert.assertThat(proxiedHello2.sayHi("Toby"), is("HI TOBY"));
		Assert.assertThat(proxiedHello2.sayThankyou("Toby"), is("THANK YOU TOBY"));
	}
}
