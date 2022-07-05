package my_demo.aop.autoconfig.customAdvisor;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceAdvisor implements PointcutAdvisor {

    @Autowired
    private StudentServicePointCut studentServicePointCut;

    @Autowired
    private StudentServiceAdvice studentServiceAdvice;

    @Override
    public Pointcut getPointcut() {
        return studentServicePointCut;
    }

    @Override
    public Advice getAdvice() {
        return studentServiceAdvice;
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}
