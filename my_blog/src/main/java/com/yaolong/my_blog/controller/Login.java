package com.yaolong.my_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("/index")
    public String index(){
        return "myblog/index";
    }
    @RequestMapping("/about")
    public String about(){
        return "myblog/about";
    }
    @RequestMapping("/blog")
    public String blog(){
        return "myblog/blog";
    }
    @RequestMapping("/contact")
    public String contact(){
        return "myblog/contact";
    }
    @RequestMapping("/support")
    public String support(){
        return "myblog/support";
    }
}

