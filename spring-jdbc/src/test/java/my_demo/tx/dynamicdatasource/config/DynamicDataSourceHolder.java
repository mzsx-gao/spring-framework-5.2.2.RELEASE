package my_demo.tx.dynamicdatasource.config;

public class DynamicDataSourceHolder {

    private static ThreadLocal<String> local = new ThreadLocal<String>();

    public static String getDs() {
        return local.get();
    }

    public static ThreadLocal getLocal() {
        return local;
    }
}
