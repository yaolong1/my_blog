package com.yaolong.my_blog.controller;

import com.yaolong.my_blog.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 殷跃龙
 * @Description:
 * @Date: Create in 16:25 2019/8/11
 * 自定义异常通知
 */
@ControllerAdvice
public class MyExceptionHandler {
    //1.浏览器和客户端都是返回json数据
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String,Object> handlerException(Exception e){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.not exist");
//        map.put("message",e.getMessage());
//       return map;
//    }

    /**
     * 转发到/error进行自适应响应效果处理
     * @param e
     * @return
     */
    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap();
        //传入自己的状态码 4xx.5xx,否则不会进入定制错误页面的介解析过程默认是200
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code", "user.not exist");
        map.put("message", e.getMessage());
        request.setAttribute("ext",map);
        return "forward:/error";
    }

}
