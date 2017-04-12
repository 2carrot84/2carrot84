package springbook.learningtest.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UppercaseHandler implements InvocationHandler {
	//	Hello target;
	//	
	//	public UppercaseHandler(Hello target) {
	//		this.target = target;
	//	}
	Object target;

	public UppercaseHandler(Object target) {
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
		String ret = (String)method.invoke(target, args);
		
		if(ret instanceof String) {
			return ((String)ret).toUpperCase();
		}
		
		return ret;
	}
}
