package my_demo.aop.autoconfig.scopedProxy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ScopedProxyBean {

    public void code() {
        System.out.println(this.hashCode());
    }
}
