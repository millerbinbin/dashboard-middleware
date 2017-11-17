package com.jd.logistics.cloud.data.implement;

import com.jd.logistics.cloud.data.commons.helper.MD5Helper;
import com.jd.logistics.cloud.data.domain.RequestError;
import com.jd.logistics.cloud.data.domain.User;
import com.jd.logistics.cloud.data.repository.UserRepository;
import com.jd.logistics.cloud.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 9:13
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserByName(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public RequestError checkUserPwd(String username, String password) {
        User user = getUserByName(username);
        if (user == null)
            return new RequestError("账户不存在，请重新输入！");
        String encryptPwd = user.getPassword();
        if (! MD5Helper.validateMD5Password(password, username, encryptPwd))
            return new RequestError("密码不正确！");
        return null;
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getById(id);
    }

    @Override
    public String[] getRolesByUsername(String username) {
        String roles = userRepository.getRolesByUsername(username);
        return roles.split(",");
    }
}
