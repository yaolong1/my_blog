package com.yaolong.my_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: 殷跃龙
 * @Description:
 * @Date: Create in 19:06 2019/8/10
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        session.setAttribute("username",username);
        if (!StringUtils.isEmpty(username)&&password.equals("123456")){
            //登录成功
            map.put("msg","登录成功");
            return "redirect:/main.html";
        }else {
            //登录失败
            map.put("msg","登录失败");
            return "StaffingSystem/login" ;
        }

    }
}
