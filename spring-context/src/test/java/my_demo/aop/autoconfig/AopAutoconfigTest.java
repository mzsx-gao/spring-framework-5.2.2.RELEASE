package my_demo.aop.autoconfig;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopAutoconfigTest {

    /**
     * 真正的AOP示例（注解方式）
     */
    @Test
    public void testAop(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ICalculatorService arithmeticCalculator = ctx.getBean(ICalculatorService.class);
        System.out.println("获取的bean是代理类..."+arithmeticCalculator.getClass().getName());
        arithmeticCalculator.add(11, 12);
//        arithmeticCalculator.div(21, 0);
    }

}
