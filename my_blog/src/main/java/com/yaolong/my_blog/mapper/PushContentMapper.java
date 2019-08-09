package com.yaolong.my_blog.mapper;

import com.yaolong.my_blog.entity.PushContent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yaoLong
 * @date 2019/8/7  15:44
 */
@Repository
public interface PushContentMapper {
    @Insert("insert into image(file_name,path,user_name,date,content,title,variety) values(#{file_name},#{path},#{user_name},#{date},#{content},#{title},#{variety})")
    public void savePushArticleDate(PushContent content);
    @Select("select * from image")
    public List<PushContent> getPushArticleDate();
}
