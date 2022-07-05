package com.gao.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gao.interceptor.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
		registry.enableContentNegotiation(new MappingJackson2JsonView());
		//比如我们想用JSP解析器,默认所有的页面都从/WEB-INF/AAA.jsp
		registry.jsp("/WEB-INF/pages/",".jsp");
	}

    /**
     * 静态资源访问,静态资源交给tomcat来处理
     * 这个配置会把 "/**" url,注册到 SimpleUrlHandlerMapping 的 urlMap 中,把对静态资源的访问由 HandlerMapping 转到
     * org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler 处理并返回
     */
//    @Override
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//		 configurer.enable();
//	}
	
	 //拦截器,源码内部WebMvcConfigurationSupport#getInterceptors会调过来
	 @Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
	}

	//自定义扩展http消息转换器
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		for(HttpMessageConverter msgConverter : converters){
			if(msgConverter instanceof MappingJackson2HttpMessageConverter){
                //设置日期格式
				MappingJackson2HttpMessageConverter converter =  (MappingJackson2HttpMessageConverter)msgConverter;
				ObjectMapper objectMapper = converter.getObjectMapper();
				SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd");
				objectMapper.setDateFormat(smt);
				converter.setObjectMapper(objectMapper);
			}
		}
	}

	//跨域配置
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/crossOrigin/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                .maxAge(3600);
    }
}