package my_demo.aop.autoconfig;

import my_demo.aop.autoconfig.customTargetSource.CustomTargetSourceCreator;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.config.AopConfigUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

//@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        System.out.println("设置全局拦截器和自定义targetSource。。。");
        AnnotationAwareAspectJAutoProxyCreator bean =
                (AnnotationAwareAspectJAutoProxyCreator) beanFactory.getBean(AopConfigUtils.AUTO_PROXY_CREATOR_BEAN_NAME);
        //设置全局拦截器
        bean.setInterceptorNames("girlAdvice");

        //自定义targetSource
		CustomTargetSourceCreator customTargetSourceCreator = new CustomTargetSourceCreator();
		customTargetSourceCreator.setBeanFactory(beanFactory);
		bean.setCustomTargetSourceCreators(customTargetSourceCreator);
    }
}