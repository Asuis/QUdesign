package com.asuis.qudesign.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 15988440973 on 2017/11/30.
 * desciption:
 */
@Entity
public class User {
    @Id
    private String username;
    private String password;
    @Generated(hash = 2090636610)
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Generated(hash = 586692638)
    public User() {
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
