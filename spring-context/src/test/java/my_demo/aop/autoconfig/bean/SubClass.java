package my_demo.aop.autoconfig.bean;

public class SubClass implements SuperClass<String> {
    @Override
    public String method(String param) {
        return param;
    }
}
