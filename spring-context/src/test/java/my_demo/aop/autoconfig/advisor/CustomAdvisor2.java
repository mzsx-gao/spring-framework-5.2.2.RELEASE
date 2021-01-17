package my_demo.aop.autoconfig.advisor;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class CustomAdvisor2 implements PointcutAdvisor {
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
