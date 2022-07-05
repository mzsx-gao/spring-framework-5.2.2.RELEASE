package com.gao;

import com.gao.config.MyAppConfig;
import com.gao.config.MyRootConfig;
import com.gao.filter.CorsFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;


/**
 * web容器启动的时候创建对象；调用方法来初始化容器以及前端控制器
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 获取根容器的配置类(Spring的配置文件）--父容器
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //指定配置类（配置文件）位置
        return new Class<?>[]{MyRootConfig.class};
    }

    /**
     * 获取web容器的配置类(spring-mvc 配置文件) --子容器
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MyAppConfig.class};
    }

    /**
     * 获取DispatcherServlet的映射信息
     * /:拦截所有请求（包括静态资源（xx.js,xx.png）），但是不包括*.jsp；
     * /*拦截所有请求；连*.jsp页面都拦截；jsp页面是tomcat的jsp引擎解析的；
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

//    @Override
//    protected Filter[] getServletFilters() {
//        CorsFilter corsFilter = new CorsFilter();
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setEncoding("UTF-8");
//        characterEncodingFilter.setForceEncoding(true);
//        return new Filter[]{corsFilter, characterEncodingFilter};
//    }

}
