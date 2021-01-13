package my_demo.baseioc.constomScope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 名称: Test
 * 描述: 自定义scope
 *
 * @author gaoshudian
 * @date 1/2/21 10:09 PM
 */
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		CustomScopeBean bean = ac.getBean(CustomScopeBean.class);
		System.out.println(bean);
	}
}
