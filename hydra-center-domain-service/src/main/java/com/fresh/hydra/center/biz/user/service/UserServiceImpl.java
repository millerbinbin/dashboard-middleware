package com.fresh.hydra.center.biz.user.service;

import com.fresh.commons.data.page.Page;
import com.fresh.commons.data.page.PageRequest;
import com.fresh.hydra.center.biz.user.domain.UserQuery;
import com.fresh.hydra.center.biz.user.domain.User;
import com.fresh.hydra.center.biz.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by yanhua on 2017/2/3.
 */
//@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> findUserPage(UserQuery query, PageRequest pageRequest) {
        List<User> userList = userRepository.findUserList(query, pageRequest);
        long count = userRepository.count(query);
        Page<User> userPage =  new Page<>();
        userPage.setPage(pageRequest.getPage());
        userPage.setSize(pageRequest.getPageSize());
        userPage.setTotalElements(count);
        userPage.setContent(userList);
        return userPage;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void updateUser(User user) throws DuplicateUsernameException {
        Assert.notNull(user.getId(), "user id is null.");
        User u = userRepository.getByName(user.getName());
        if(u != null  && !u.getId().equals(user.getId())) {
            throw new DuplicateUsernameException();
        }

        userRepository.update(user);

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void addUser(User user) throws DuplicateUsernameException {
        User u = userRepository.getByName(user.getName());
        if(u != null  && !u.getId().equals(user.getId())) {
            throw new DuplicateUsernameException();
        }
        userRepository.add(user);
    }


//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
}
