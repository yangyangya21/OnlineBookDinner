package com.yjq.server.dto;

/**
 * 用户数据传输对象  作用于service和controller
 */
public class UserDto {
    private String id;

    private String username;

    private String password;

    private String roleId;

    private String token; //用户携带的token

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId='" + roleId + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}