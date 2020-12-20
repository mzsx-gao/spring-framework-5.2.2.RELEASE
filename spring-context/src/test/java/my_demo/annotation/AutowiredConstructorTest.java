package my_demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 名称: AutowiredConstructorTest
 * 描述: TODO
 *
 * @author gaoshudian
 * @date 2020/12/20 21:03
 */
@Component
public class AutowiredConstructorTest {

    @Autowired
    public AutowiredConstructorTest(UserDao1 userDao1,UserDao2 userDao2){
        System.out.println(userDao1.toString());
        System.out.println(userDao2.toString());
    }
}
