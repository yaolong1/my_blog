package com.yaolong.my_blog.exception;

/**
 * @Author: 殷跃龙
 * @Description:
 * @Date: Create in 16:05 2019/8/11
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户登录异常");
    }
}
