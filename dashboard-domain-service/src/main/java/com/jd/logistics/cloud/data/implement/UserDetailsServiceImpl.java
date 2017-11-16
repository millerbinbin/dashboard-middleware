package com.jd.logistics.cloud.data.implement;

import com.jd.logistics.cloud.data.domain.User;
import com.jd.logistics.cloud.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/15 17:32
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {
//        User user = userRepository.getByName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
//        } else {
//            return JwtUserFactory.create(user);
//        }
        return JwtUserFactory.create(username);
    }
}
