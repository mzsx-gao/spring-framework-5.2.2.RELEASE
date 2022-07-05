package my_demo.configurationAnno;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 名称: ConfigurationTests.java
 * 描述: @Configuration与@Component注解的区别
 * 	@Configuration 注解的类中的@Bean方法被其它方法调用的时候会被切面拦截住，然后从beanFactory中取得bean而不是新创建一个实例
 *
 * @author gaoshudian
 * @date 2021/01/09 11:50 AM
 */
public class TestConfiguration {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        Lison lison = ac.getBean("lison",Lison.class);
        System.out.println(lison.hashCode());

        LisonFactory lisonFactory = ac.getBean(LisonFactory.class);
        System.out.println(lisonFactory.getLison().hashCode());
    }

    @Test
    public void test5() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Docker bean = ac.getBean(Docker.class);
        System.out.println(bean.hashCode());
    }
}