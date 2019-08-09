package com.yaolong.my_blog.service;

import com.yaolong.my_blog.entity.PushContent;
import com.yaolong.my_blog.mapper.PushContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yaoLong
 * @date 2019/8/7  15:57
 */
@Service
public class PushContentService{
    @Autowired
    PushContentMapper contentMapper;
    public void savePushArticleDate(PushContent content){
        contentMapper.savePushArticleDate(content);
    }

    public List<PushContent> getPushArticleDate(){
        return contentMapper.getPushArticleDate();
    }
}
