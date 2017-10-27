package com.fresh.hydra.center.biz.user.service;


import com.fresh.commons.data.page.Page;
import com.fresh.commons.data.page.PageRequest;
import com.fresh.hydra.center.biz.user.domain.User;
import com.fresh.hydra.center.biz.user.domain.UserQuery;


/**
 * Created by yanhua on 2017/2/3.
 */
public interface UserService {
    Page<User> findUserPage(UserQuery query, PageRequest pageRequest);

    User getUserById(Long id );

    void updateUser(User user) throws DuplicateUsernameException;

    void deleteUser(Long id);

    void addUser(User user) throws DuplicateUsernameException;

    public static class DuplicateUsernameException extends Exception{

    }
}
