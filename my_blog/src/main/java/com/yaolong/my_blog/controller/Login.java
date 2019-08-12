package com.yaolong.my_blog.controller;

import com.yaolong.my_blog.exception.UserNotExistException;
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
    @RequestMapping("/hello")
    @ResponseBody
    public String register(@RequestParam("username") String username){
        if (username.equals("aaa")){
            throw  new UserNotExistException();
        }
        return "hello word";
    }

    @RequestMapping("/text")
    public String text(){
        return "thymeleaf/test2";
    }
}
