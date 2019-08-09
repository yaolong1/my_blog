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
    @RequestMapping("/")
    public String Home(){
        return "thymeleaf/layui1";
    }
    @RequestMapping(value="/login", method = RequestMethod.GET)
        public String login(Model model){
        return "redirect:pushContent/index";
    }
    @RequestMapping("/register")
    public String register(){
        return "登录页面";
    }
}
