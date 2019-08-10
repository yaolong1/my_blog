package com.yaolong.my_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: 殷跃龙
 * @Description:
 * @Date: Create in 21:59 2019/8/7
 */
@Controller
public class Login {
    @RequestMapping("/register")
    public String register(){
        return "登录页面";
    }

    @RequestMapping("/text")
    public String text(){
        return "thymeleaf/test2";
    }
}
