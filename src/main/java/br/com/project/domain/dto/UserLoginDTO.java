package br.com.project.domain.dto;

import java.io.Serial;
import java.io.Serializable;

public class UserLoginDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
