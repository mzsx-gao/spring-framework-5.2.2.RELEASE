package my_demo.aop.autoconfig.customTargetSource;

import my_demo.aop.autoconfig.service2.CalculatorServiceImpl;
import org.springframework.aop.framework.autoproxy.target.AbstractBeanFactoryBasedTargetSourceCreator;
import org.springframework.aop.target.AbstractBeanFactoryBasedTargetSource;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 名称: CustomTargetSourceCreator
 * 描述: 自定义创建targetSource的creator
 *
 * @author gaoshudian
 * @date 2021/1/17 21:23
 */
public class CustomTargetSourceCreator extends AbstractBeanFactoryBasedTargetSourceCreator {

    @Override
    protected AbstractBeanFactoryBasedTargetSource createBeanFactoryBasedTargetSource(Class<?> beanClass,
                                                                                      String beanName) {
        if(getBeanFactory() instanceof ConfigurableListableBeanFactory){
            if(beanClass.isAssignableFrom(CalculatorServiceImpl.class)){
                return new CustomTargetSource();
            }
        }
        return null;
    }
}