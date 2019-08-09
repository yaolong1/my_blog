package com.yaolong.my_blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yaoLong
 * @date 2019/8/7  15:43
 */
@Data
public class PushContent implements Serializable {
    private String path;
    private String file_name;
    private String user_name;
    private String date;
    private String content;
    private String title;
    private String variety;

}
