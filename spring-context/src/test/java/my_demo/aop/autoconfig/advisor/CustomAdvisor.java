package my_demo.aop.autoconfig.advisor;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 自定义切面，源码中在AnnotationAwareAspectJAutoProxyCreator#findCandidateAdvisors#super.findCandidateAdvisors()方法中加载
 */
@Component
@Order(1)
public class CustomAdvisor implements PointcutAdvisor {
    @Override
    public Pointcut getPointcut() {
        return Pointcut.TRUE;
    }

    @Override
    public Advice getAdvice() {
        return new CustomAdvice();
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}
