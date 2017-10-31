package com.jd.logistics.cloud.data.service;

import com.jd.logistics.cloud.data.domain.User;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 9:13
 */
public interface UserService {
    User getUserByName(String username);

    boolean checkPwd(String username, String pwd);

    boolean checkUser(String username);

    User getUserById(long id);
}
