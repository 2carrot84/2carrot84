package springbook.user.service.handler;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by eguns on 2017. 6. 25..
 */
public class TransactionHandler implements InvocationHandler {
    private Object target;  // 부가기능을 제공할 타깃 오브젝트
    private PlatformTransactionManager transactionManager; // 트랜잭션 기능을 제공할 추상화 트랜잭션 매니저
    private String pattern; // 트랜잭션을 적용할 패턴

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith(pattern)) {  // 트랜잭션 적용 대상 선정
            return invokeTransaction(method, args);
        }
        else {
            return method.invoke(target, args);
        }
    }

    private Object invokeTransaction(Method method, Object[] args) throws Throwable {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            Object ret = method.invoke(target, args);
            transactionManager.commit(status);
            return ret;
        } catch (IllegalAccessException e) {
            transactionManager.rollback(status);
            throw e;
        } catch (InvocationTargetException e) {
            transactionManager.rollback(status);
            throw e.getTargetException();
        }
    }

}
