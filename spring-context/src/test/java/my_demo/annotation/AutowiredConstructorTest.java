package my_demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 名称: AutowiredConstructorTest
 * 描述: 主要是测试AbstractAutowireCapableBeanFactory#createBeanInstance方法
 *
 * @author gaoshudian
 * @date 2020/12/20 21:03
 */
@Component
public class AutowiredConstructorTest {

	public AutowiredConstructorTest(){

	}

    @Autowired
    public AutowiredConstructorTest(UserDao1 userDao1,UserDao2 userDao2){
        System.out.println(userDao1.toString());
        System.out.println(userDao2.toString());
    }

    @Bean
    public AutowiredConstructorTest getAutowiredConstructorTest(){
    	return new AutowiredConstructorTest();
	}
}
