package com.jd.logistics.cloud.data.service;

import com.jd.logistics.cloud.data.domain.RequestError;
import com.jd.logistics.cloud.data.domain.User;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 9:13
 */
public interface UserService {
    User getUserByName(String username);

    RequestError checkUserPwd(String username, String password);

    User getUserById(long id);

    String[] getRolesByUsername(String username);
}
