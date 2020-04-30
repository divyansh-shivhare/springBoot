package com.persistent.pip.model;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")

// To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate
public class User {
    @Id
    private String  userId;
    private String password;
    private String roleAccess;

    public User() {
    }

    public User( String userId) {

        this.userId = userId;
        this.password = "PASSWORD";
        this.roleAccess ="USER";
    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleAccess() {
        return roleAccess;
    }

    public void setRoleAccess(String roleAccess) {
        this.roleAccess = roleAccess;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", roleAccess='" + roleAccess + '\'' +
                '}';
    }
}
