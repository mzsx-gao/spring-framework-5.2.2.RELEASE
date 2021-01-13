package my_demo.configClassTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Value("test.name")
    private String name;

    public MyService(){
        System.out.println("这个类的name是："+name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
