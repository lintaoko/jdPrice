package info.xiantang.model;

import java.io.Serializable;

public class User implements Serializable {

    private int userId;
    private String userName;
    private String passWord;

    public User() {
    }

    private String email;

    public User(String userName, String passWord, String email) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
    }

    public User(int userId, String userName, String passWord, String email) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
