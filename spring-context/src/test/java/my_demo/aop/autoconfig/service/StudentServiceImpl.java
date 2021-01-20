package my_demo.aop.autoconfig.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @EasyCache
    @Override
    public void eat(String a) {
        System.out.println("=====StudentServiceImpl.eat");
//        StudentServiceImpl o = (StudentServiceImpl)AopContext.currentProxy();
        StudentService bean = applicationContext.getBean(StudentService.class);
    }

    @Override
    public String sleep(List b) {
        System.out.println("=====StudentServiceImpl.sleep");
        if(true)throw new RuntimeException("xx");
        return "=====StudentServiceImpl.sleep";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
