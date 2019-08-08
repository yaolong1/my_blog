package com.yaolong.my_blog.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author yaoLong
 * @date 2019/8/6  14:33
 */
@SpringBootConfiguration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:C:/SSM/my_blog/my_blog/src/main/resources/image");
        registry.addResourceHandler("/pig/**").addResourceLocations("file:C:/pig/");
        super.addResourceHandlers(registry);
    }

}
