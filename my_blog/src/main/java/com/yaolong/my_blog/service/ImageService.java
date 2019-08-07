package com.yaolong.my_blog.service;

import com.yaolong.my_blog.entity.Image;
import com.yaolong.my_blog.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yaoLong
 * @date 2019/8/7  15:57
 */
@Service
public class ImageService {
    @Autowired
    ImageMapper imageMapper;
    public void savePath(Image image){
        imageMapper.savePath(image);
    }

    public List<Image> getPath(){
        return imageMapper.getPath();
    }
}
