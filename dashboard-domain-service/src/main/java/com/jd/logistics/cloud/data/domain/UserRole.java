package com.jd.logistics.cloud.data.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/16 13:44
 */
@Data
public class UserRole implements Serializable{
    private static final long serialVersionUID = 1375529097307228800L;
    private String username;
    private List<String> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
