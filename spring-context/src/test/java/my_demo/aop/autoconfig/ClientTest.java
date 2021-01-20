package my_demo.aop.autoconfig;

import my_demo.aop.autoconfig.scopedProxy.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientTest {

    /**
     * aop自动装配方式
     */
    @Test
    public void test(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ICalculatorService arithmeticCalculator = ctx.getBean(ICalculatorService.class);
        System.out.println("获取的bean是代理类..."+arithmeticCalculator.getClass().getName());
        arithmeticCalculator.add(11, 12);
//        arithmeticCalculator.div(21, 0);
    }

    //测试scopeProxy
	@Test
	public void test2() {
		AnnotationConfigApplicationContext aa = new AnnotationConfigApplicationContext(AppConfig.class);
		MyBean bean = aa.getBean(MyBean.class);
		for (int i = 0; i < 2; i++) {
			bean.tet();
		}
	}
}