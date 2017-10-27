package com.fresh.hydra.man.web.user.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户相关的控制器
 * Created by yanhua on 2017/1/20.
 */
@Controller
@RequestMapping("/user")
public class UserViewController {

    @GetMapping("/list")
    public String list() {
        return "user/user_list";
    }
}
