package my_demo.configurationAnno;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 名称: ConfigurationTests.java
 * 描述: 测试@Configuration与@Component注解的区别
 *
 * @author gaoshudian
 * @date 2021/01/09 11:50 AM
 */
public class ConfigurationTests {

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
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Docker bean = applicationContext.getBean(Docker.class);
        System.out.println(bean.hashCode());
    }
}