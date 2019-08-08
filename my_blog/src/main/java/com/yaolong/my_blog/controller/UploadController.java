package com.yaolong.my_blog.controller;

import com.yaolong.my_blog.entity.Image;
import com.yaolong.my_blog.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author yaoLong
 * @date 2019/8/7  15:34
 */
@Controller
@RequestMapping("/images")
public class UploadController {
    @Autowired
    ImageService imageService;

    @PostMapping("/save")
    @ResponseBody
    public void savePath(Image image,@RequestParam( "file")MultipartFile upload) {
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
            image = new Image();
            image.setFilename(filename);
            image.setPath("/pig/"+filename);
            imageService.savePath(image);
            System.out.println("文件上传成功！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件上传失败！");
        }
    }

    @GetMapping("/get")
    public String getPath(Model mode){
        List<Image> images = imageService.getPath();
        mode.addAttribute("img",images);
        return "/thymeleaf/test";
    }

    }
