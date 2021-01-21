package my_demo.aop.autoconfig.scopedProxy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * 生成ScopedProxyBean的代理类的beandefinition的beanClass是ScopedProxyFactoryBean，在MyBean依赖注入ScopedProxyBean属性时
 * 触发ScopedProxyFactoryBean的getObject()方法获取目标bean;
 * 源码实现的地方:
 * ConfigurationClassPostProcessor#processConfigBeanDefinitions
 * ConfigurationClassParser#doProcessConfigurationClass
 * ComponentScanAnnotationParser#parse
 * ClassPathBeanDefinitionScanner#doScan
 * AnnotationConfigUtils.applyScopedProxyMode
 */
@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ScopedProxyBean {

    public void code() {
        System.out.println(this.hashCode());
    }
}
