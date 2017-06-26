package springbook.user.service.proxyFactoryBean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Created by eguns on 2017. 6. 26..
 */
public class TransactionAdvice implements MethodInterceptor {
    PlatformTransactionManager transactionManager;

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    // 타깃을 호출하는 기능을 가진 콜백 오브젝트(methodInvocation)
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            Object ret = methodInvocation.proceed();    // 타깃의 메소드 실행
            this.transactionManager.commit(status);
            return ret;
        }
        catch (RuntimeException e) {
            this.transactionManager.rollback(status);
            throw e;
        }
    }
}
