package my_demo.aop.autoconfig.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * 全局拦截器，在my_demo.aop.autoconfig.MyBeanFactoryPostProcessor中被设置到
 * AnnotationAwareAspectJAutoProxyCreator的interceptorNames属性中
 * 源码调用地方:AbstractAutoProxyCreator#createProxy#buildAdvisors
 */
@Component
public class GirlAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
//        System.out.println("=======GirlAdvice.invoke");
        return invocation.proceed();
    }
}
