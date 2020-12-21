package my_demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 名称: AutowiredConstructorTest
 * 描述:
 * 1.测试AbstractAutowireCapableBeanFactory#createBeanInstance方法
 * 2.测试CommonAnnotationBeanPostProcessor对@PostConstruct的处理
 *
 * @author gaoshudian
 * @date 2020/12/20 21:03
 */
@Component
public class TestInstantBean {

	public TestInstantBean(){

	}

    @Autowired
    public TestInstantBean(UserDao1 userDao1, UserDao2 userDao2){
        System.out.println(userDao1.toString());
        System.out.println(userDao2.toString());
    }

    @Bean
    public TestInstantBean getTestInstantBean(){
    	return new TestInstantBean();
	}

	@PostConstruct
	public void testPostConstruct(){
        System.out.println("TestInstantBean实例化过程中执行了我。。。");
    }
}
