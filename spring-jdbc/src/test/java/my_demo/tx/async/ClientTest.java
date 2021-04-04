package my_demo.tx.async;

import my_demo.tx.cacheAdvisor.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 名称: ClientTest
 * 描述: @Async功能测试
 *
 * @author gaoshudian
 * @date 2021/4/4 11:31
 */
public class ClientTest {
	@Test
	public void test1() throws Exception{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AsyncConfig.class);
		AsyncService bean = ac.getBean(AsyncService.class);
		bean.queryData("29843921");
		System.out.println("看谁先跑");
		Thread.sleep(Integer.MAX_VALUE);
	}
}