package com.jd.logistics.cloud.data.service;

import com.jd.logistics.cloud.data.domain.User;
import com.jd.logistics.cloud.data.repository.UserRepository;
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
        return userRepository.getByName(username);
    }

    @Override
    public boolean checkPwd(String username, String pwd) {
        return pwd.equals(userRepository.getByName(username).getPassword());
    }

    @Override
    public boolean checkUser(String username) {
        return null != getUserByName(username);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.getById(id);
    }
}
