package my_demo.aop.autoconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@EnableAspectJAutoProxy(proxyTargetClass = false, exposeProxy = true)
@ComponentScan
@Configuration
public class AppConfig {

}
