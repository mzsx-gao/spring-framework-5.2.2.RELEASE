package my_demo.configurationAnno;

import org.springframework.beans.factory.FactoryBean;

public class LiLi implements FactoryBean {

    @Override
    public Object getObject() {
        return new Docker();
    }

    @Override
    public Class<?> getObjectType() {
        return Docker.class;
    }

    public void xae() {
        System.out.println("xae");
    }
}
