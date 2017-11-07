package mvpframework.bwie.com.mvpframework;

/**
 * Created by CZ on 2017/11/7.
 */
public class User {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public User(String password, String username) {

        this.password = password;
        this.username = username;
    }
}


