package my_demo.aop.autoconfig.customTargetSource;

import org.springframework.aop.target.AbstractBeanFactoryBasedTargetSource;

/**
 * 名称: CustomTargetSource
 * 描述: TODO
 *
 * @author gaoshudian
 * @date 2021/1/17 21:27
 */
public class CustomTargetSource extends AbstractBeanFactoryBasedTargetSource {
    @Override
    public Object getTarget() throws Exception {
        return getBeanFactory().getBean(getTargetBeanName());
    }
}
