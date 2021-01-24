package my_demo.tx.autoconfig;

import my_demo.tx.autoconfig.service.BookShopService;
import my_demo.tx.autoconfig.service.Cashier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * 名称: ClientTest
 * 描述: spring事务功能测试
 *
 * @author gaoshudian
 * @date 2021/1/23 11:31
 */
public class ClientTest {

    public static void main(String[] args) {
        ApplicationContext aa = new AnnotationConfigApplicationContext(AppConfig.class);

        //测试普通事务
//        BookShopService bs = aa.getBean(BookShopService.class);
//        bs.purchase("AA", "1001");

        //测试嵌套事务
        Cashier ca = aa.getBean(Cashier.class);
        ca.checkout("AA", Arrays.asList("1001", "1002"));
    }

}
