package my_demo.demo;

/**
 * 名称: PlaceHolder
 * 描述: 测试占位符解析
 *
 * @author gaoshudian
 * @date 2020/12/27 20:43
 */
public class PlaceHolder {
    private String user = null;
    private String password = null;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PlaceHolder{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
