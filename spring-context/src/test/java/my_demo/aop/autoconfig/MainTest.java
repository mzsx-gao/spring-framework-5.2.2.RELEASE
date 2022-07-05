package my_demo.aop.autoconfig;

import my_demo.aop.autoconfig.bean.SubClass;
import my_demo.aop.autoconfig.scopedProxy.MyBean;
import my_demo.aop.autoconfig.service.StudentService;
import my_demo.aop.autoconfig.service2.ICalculatorService;
import org.junit.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Method;

public class MainTest {

    /**
     * aop自动装配方式
     */
    @Test
    public void test(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ICalculatorService arithmeticCalculator = ctx.getBean(ICalculatorService.class);
        System.out.println("获取的bean是代理类..."+arithmeticCalculator.getClass().getName());
        arithmeticCalculator.add(11, 12);
    }

    //测试scopeProxy
	@Test
	public void test2() {
		AnnotationConfigApplicationContext aa = new AnnotationConfigApplicationContext(AppConfig.class);
		MyBean bean = aa.getBean(MyBean.class);
		for (int i = 0; i < 2; i++) {
			bean.tet();
		}
	}

    @Test
    public void test3() {
        AnnotationConfigApplicationContext aa = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentService bean = aa.getBean(StudentService.class);
//        System.out.println(bean);
//        bean.sleep(new ArrayList());
        bean.eat("Jack");
    }

    //测试桥接方法示例
	//一个子类在继承（或实现）一个父类（或接口）的泛型方法时，在子类中明确指定了泛型类型，那么在编译时编译器会自动生成桥接方法
	@Test
	public void BridgeMethodResolver() {
    	//获取SubClass的所有方法包括桥接方法
		//这里发现SubClass中多了一个method方法，java.lang.Object my_demo.aop.autoconfig.bean.SubClass.method(java.lang.Object)
		ReflectionUtils.getAllDeclaredMethods(SubClass.class);
		//桥接方法
		Method method1 = ClassUtils.getMethod(SubClass.class, "method", new Class[]{Object.class});
		System.out.println(method1.isBridge() + "--" + method1.hashCode());
		//原始方法
		Method method = ClassUtils.getMethod(SubClass.class, "method", new Class[]{String.class});
		System.out.println(method.isBridge() + "--" + method.hashCode());

		//获取桥接方法对应的原始方法
		Method bridgedMethod = BridgeMethodResolver.findBridgedMethod(method1);
		//内部会调用BridgeMethodResolver.findBridgedMethod
		Method specificMethod = AopUtils.getMostSpecificMethod(method1, SubClass.class);
		System.out.println(bridgedMethod.hashCode());
		System.out.println(specificMethod.hashCode());
	}
}