package com.gao.config;


import com.gao.interceptor.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;


/**
 * SpringMVC只扫描Controller；子容器
 * useDefaultFilters=false 禁用默认的过滤规则；
 */
@ComponentScan(
        value="com.gao",
		includeFilters={@Filter(type= FilterType.ANNOTATION,classes={Controller.class})},
        useDefaultFilters=false)
// 开启springmvc功能，内部会向spring容器注入一些bean（handlerMapping、handlerMappingAdapter等）,
// 实现在WebMvcConfigurationSupport类中会有很多@Bean方法
@EnableWebMvc
public class MyAppConfig implements WebMvcConfigurer {
	
	//定制视图解析器
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		//比如我们想用JSP解析器,默认所有的页面都从/WEB-INF/AAA.jsp
		registry.jsp("/WEB-INF/pages/",".jsp");
	}
	
	//静态资源访问,静态资源交给tomcat来处理
	 @Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		 configurer.enable();
	}
	
	 //拦截器,源码内部WebMvcConfigurationSupport#getInterceptors会调过来
	 @Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
	}
}