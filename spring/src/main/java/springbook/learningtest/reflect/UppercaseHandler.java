package springbook.learningtest.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by eguns on 2017. 6. 20..
 */
public class UppercaseHandler implements InvocationHandler {
    Object target;

    public UppercaseHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = method.invoke(target, args);   // 타깃 위임, 인터페이스 메소드 호출

        if(ret instanceof String && method.getName().startsWith("say")) {
            return ((String)ret).toUpperCase();   // 부가기능
        }
        else {
            return ret;
        }
    }
}
