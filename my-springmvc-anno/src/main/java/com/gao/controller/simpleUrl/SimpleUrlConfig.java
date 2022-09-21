package com.gao.controller.simpleUrl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

@Configuration
public class SimpleUrlConfig {

    @Bean
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
        SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
        Properties properties = new Properties();
        properties.put("area/index","areaController");
		simpleUrlHandlerMapping.setMappings(properties);
        /**
         * 当MyAppConfig中配置了configureDefaultServletHandling时这里的这个order值就很关键，要保证这个SimpleUrlHandlerMapping
         * 在默认的DefaultServletHttpRequestHandler（处理路径是/**）对应的SimpleUrlHandlerMapping前面，
         * 不然就被DefaultServletHttpRequestHandler先处理了，DispatcherServlet初始化HandlerMappings是会按order进行排序
         */
        simpleUrlHandlerMapping.setOrder(100);
        return simpleUrlHandlerMapping;
    }
}
