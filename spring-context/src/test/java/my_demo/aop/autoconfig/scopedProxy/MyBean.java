package my_demo.aop.autoconfig.scopedProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Autowired
    private ScopedProxyBean scopedProxyBean;

    public void tet() {
        scopedProxyBean.code();
    }
}
