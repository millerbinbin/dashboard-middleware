package com.fresh.hydra.man.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页对应的控制器
 * Created by yanhua on 2017/1/18.
 */
@Controller
public class IndexViewController {

    @GetMapping("/")
    public String index(){
        return "welcome";
    }
    @RequestMapping(value = "/doc")
    public String doc() {
        return "redirect:swagger-ui.html";
    }
}
