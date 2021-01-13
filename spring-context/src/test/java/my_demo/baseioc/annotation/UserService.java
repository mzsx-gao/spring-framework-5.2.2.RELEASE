package my_demo.baseioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

//若注解没有指定 bean 的 id, 则类名第一个字母小写即为 bean 的 id
@Service
public class UserService implements EnvironmentAware {

    /**
     * 当有多个候选者时，确定出正确的候选者
     * 1.处理@Primary注解
     * 2.处理@Priority注解
     * 3.属性名等于哪个bean的id就选用哪个bean
     */
    @Autowired
    private IUserDao userDao1;

    //测试@Value的用法
    @Value("${placeHolder.love}")
    private String like;

    public void addNew(User entity){
        System.out.println("addNew by " + userDao1);
        userDao1.save(entity);
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println(like);
        System.out.println(environment.getProperty("placeHolder.love"));//拿不到
    }
}
