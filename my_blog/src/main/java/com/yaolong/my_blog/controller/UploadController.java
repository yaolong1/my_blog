package com.yaolong.my_blog.controller;


import com.yaolong.my_blog.entity.PushContent;

import com.yaolong.my_blog.service.PushContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yaoLong
 * @date 2019/8/7  15:34
 */
@Controller
@RequestMapping("/pushContent")
public class UploadController {
    @Autowired
    PushContentService contentService;

    @PostMapping(value = "/save",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String, Object> savePath(PushContent content, @RequestParam( "file")MultipartFile upload) {
        Map<String, Object> res = new HashMap<>();
        Map<String,Object> res2 = new HashMap();
        System.out.println(content);
        // 先获取到要上传的文件目录
        String path ="C:/pig/";
        // 创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if (!file.exists()) {
            file.mkdirs();
        }
        // 获取到上传文件的名称

        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        // 把文件的名称唯一化
         filename = uuid+"_"+filename;
        System.out.println(file+filename);
         // 上传文件
        try {
            upload.transferTo(new File(path+filename));
            content.setFile_name(filename);
            content.setPath("/pig/"+filename);
            content.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            contentService.savePushArticleDate(content);
            res.put("code", 0);
            res.put("data",res2);
            res2.put("src","/pig/"+filename);
            res2.put("title",filename);
            return res;
        } catch (IOException e) {
            e.printStackTrace();
            res.put("code", -1);
            res.put("msg", "上传失败");
            return res;
        }
    }

    @GetMapping("/get")
    public String getPushArticleDate(Model mode){
        List<PushContent> contents = contentService.getPushArticleDate();
        mode.addAttribute("content",contents);
//        return "/thymeleaf/test";
        return "myblog/index";
    }

    }
