package my_demo.tx.dynamicdatasource.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectConfig {

	@Around(value = "@annotation(targetSource)",argNames = "joinPoint,targetSource")
	public void aroundMethod(ProceedingJoinPoint joinPoint, TargetDataSource targetSource) {

		System.out.println("========切面拦截响应方法然后动态设置数据源======");
		String value = targetSource.value();

		if(value != null && !"".equals(value)) {
			DynamicDataSourceHolder.getLocal().set(value);
		} else {
			DynamicDataSourceHolder.getLocal().set("ds1");
		}
		try {
			joinPoint.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
	}
}
