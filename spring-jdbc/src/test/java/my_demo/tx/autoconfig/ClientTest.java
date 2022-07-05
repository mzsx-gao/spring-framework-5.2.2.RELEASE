package my_demo.tx.autoconfig;

import my_demo.tx.autoconfig.service.impl.BookShopServiceImpl;
import my_demo.tx.autoconfig.service.impl.CashierImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 名称: ClientTest
 * 描述: spring事务功能测试
 *
 * @author gaoshudian
 * @date 2021/1/23 11:31
 */
public class ClientTest {

    //测试普通事务
    @Test
    public void test1(){
        ApplicationContext aa = new AnnotationConfigApplicationContext(AppConfig.class);
        BookShopServiceImpl bs = aa.getBean(BookShopServiceImpl.class);
        bs.purchase("AA", "1001");
    }

    //测试嵌套事务
    @Test
    public void test2(){
        ApplicationContext aa = new AnnotationConfigApplicationContext(AppConfig.class);
        CashierImpl ca = aa.getBean(CashierImpl.class);
        ca.checkout("AA", "1001");
    }

    //嵌套事务,try-catch包装外层事务，内层事务是REQUIRED
    @Test
    public void test3(){
        ApplicationContext aa = new AnnotationConfigApplicationContext(AppConfig.class);
        CashierImpl ca = aa.getBean(CashierImpl.class);
        ca.checkout2("AA", "1001");
    }

    //嵌套事务,try-catch包装外层事务，内层事务是NESTED
    @Test
    public void test4(){
        ApplicationContext aa = new AnnotationConfigApplicationContext(AppConfig.class);
        CashierImpl ca = aa.getBean(CashierImpl.class);
        ca.checkout3("AA", "1001");
    }
}