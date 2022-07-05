package my_demo.aop.autoconfig.customTargetSource;

import org.springframework.aop.target.AbstractBeanFactoryBasedTargetSource;

/**
 * 名称: CustomTargetSource
 * 描述: 自定义targetSource
 *
 * @author gaoshudian
 * @date 2021/1/17 21:27
 */
public class CustomTargetSource extends AbstractBeanFactoryBasedTargetSource {

    @Override
    public Object getTarget() {
        /**
         * 这里触发beanFactory.getBean()正常情况应该返回CalculatorServiceImpl的代理，因为CalculatorServiceImpl注册到beanFacory中
         * 的就是其代理类，但是这里确没有返回代理类，这是为什么？
         * 这是因为这里的getBeanFactory已经不是主beanFactory了，而是在获取targetSource时又新创建了一个beanFactory,源码位置:
         * AbstractBeanFactoryBasedTargetSourceCreator#getTargetSource
         */
        return getBeanFactory().getBean(getTargetBeanName());
    }
}
