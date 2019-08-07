package com.yaolong.my_blog.mapper;

import com.yaolong.my_blog.entity.Image;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yaoLong
 * @date 2019/8/7  15:44
 */
@Repository
public interface ImageMapper {
    @Insert("insert into image values(#{id},#{path}) ")
    public void savePath(Image image);
    @Select("select * from image")
    public List<Image> getPath();
}
