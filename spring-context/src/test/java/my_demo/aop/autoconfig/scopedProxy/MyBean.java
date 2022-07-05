package my_demo.aop.autoconfig.scopedProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    /**
     * 这里注入的是scopedProxyBean的代理类，代理类的beanClass是ScopedProxyFactoryBean,
     * ScopedProxyFactoryBean是一个FactoryBean,实例化ScopedProxyFactoryBean时会调用getObject()方法
     * ScopedProxyFactoryBean的setBeanFactory（）方法内部会生成一个代理，这个代理就是getObject()方法返回的一个代理对象
     */
    @Autowired
    private ScopedProxyBean scopedProxyBean;

    public void tet() {
        /**
         * 这里拿到的是代理类，而调用代理类的方法会被切面拦住走到CglibAopProxy#DynamicAdvisedInterceptor#intercept()方法
         * 在intercept()方法中会调用targetSource.getTarget()方法获取目标bean，而此时的targetSource是SimpleBeanTargetSource，
         * 它的getObject()方法会通过getBeanFactory().getBean(getTargetBeanName())来获取目标bean，而由于目标bean的作用域是
         * prototype，所以每次获取到的bean都不一样
         */
        scopedProxyBean.code();
    }
}
