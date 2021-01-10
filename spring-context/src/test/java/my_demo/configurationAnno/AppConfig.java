package my_demo.configurationAnno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Configuration 注解和@Component注解的区别
 */
//@Component
@Configuration
public class AppConfig {

    /**
     * 场景一
     */
//    @Bean
//    public Lison lison() {
//        return new Lison();
//    }
    /**
     * BeanDefinition对象
     * factoryBeanName = AppConfig
     * factoryMethodName = lisonFactory
     */
//    @Bean
//    public LisonFactory lisonFactory() {
//        LisonFactory lisonFactory = new LisonFactory();
//        //lison() beanFactory.getBean(id)  缓存里面
//        lisonFactory.setLison(this.lison());
//        return lisonFactory;
//    }


    /**
     * 场景二：LiLi是一个FactoryBean的情况
     */
    @Bean
    public LiLi liLi() {
        return new LiLi();
    }

    @Bean
    public LisonFactory lisonFactory2(){
        LiLi liLi = this.liLi();
        // beanFactory.getBean()
        Object object = liLi.getObject();
        System.out.println("lili getObject : " + object.hashCode());
        liLi.xae();
        return new LisonFactory();
    }


}
