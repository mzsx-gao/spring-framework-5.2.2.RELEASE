package my_demo.configClassTest;

import my_demo.configClassTest.configBean.TestBean4;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 名称: TestImportBeanDefinitionRegistrar.java
 * 描述: 通过实现ImportBeanDefinitionRegistrar接口来注册bean
 *
 * @author gaoshudian
 * @date 2019/11/28 11:49 AM
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(TestBean4.class);
        registry.registerBeanDefinition("TestBean4", rootBeanDefinition);
    }
}
