package my_demo.aop.autoconfig.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("拦截到了========StudentServiceAdvice.invoke========");
        return invocation.proceed();
    }
}
