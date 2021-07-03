package my_demo.tx.cacheAdvisor;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 名称: ClientTest
 * 描述: 缓存切面功能测试
 *
 * @author gaoshudian
 * @date 2021/4/4 11:31
 */
public class ClientTest {
	@Test
	public void test1() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		CacheService bean = ac.getBean(CacheService.class);
		bean.delete("29843921");
		bean.queryData("29843921");
		//第二次就直接从缓存中读取
		bean.queryData("29843921");
	}
}