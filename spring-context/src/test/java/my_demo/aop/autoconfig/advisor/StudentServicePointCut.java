package my_demo.aop.autoconfig.advisor;

import my_demo.aop.autoconfig.service.EasyCache;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Component
public class StudentServicePointCut implements Pointcut, MethodMatcher {

    @Override
    public ClassFilter getClassFilter() {
        return ClassFilter.TRUE;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }

    /**
     * 该方法会被调用2次，第一次是spring中其bean被实例化过程生成代理找增强器时，第二次是执行调用拦截器链时
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        //拿原始方法对象，这个方法上才有注解
        Method specificMethod = AopUtils.getMostSpecificMethod(method, targetClass);
        if(AnnotatedElementUtils.hasAnnotation(specificMethod, EasyCache.class)) {
            System.out.println("========接口方法拿注解=======" + method.isAnnotationPresent(EasyCache.class));
            System.out.println("========实现类方法拿注解=======" + specificMethod.isAnnotationPresent(EasyCache.class));
            System.out.println("matches method hashcode-->" + method.hashCode());
            return true;
        }
        return false;
    }

    @Override
    public boolean isRuntime() {
        return true;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        if(method.getName().equalsIgnoreCase("eat")) {
            List<Object> objects = Arrays.asList(args);
            String param = (String)objects.get(0);
            if("Jack".equalsIgnoreCase(param)) {
                return true;
            }
        }
        return false;
    }
}