package com.yaolong.my_blog.config;

import com.yaolong.my_blog.compoment.LoginHandlerInterceptor;
import com.yaolong.my_blog.compoment.MyLocaleResolver;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
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
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("thymeleaf/layui1");
        registry.addViewController("/login").setViewName("redirect:pushContent/index");
    }



    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {

            /**
             * 添加视图控制器
             * @param registry
             */
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("thymeleaf/layui1");
                registry.addViewController("/login").setViewName("redirect:pushContent/index");
                registry.addViewController("/test").setViewName("thymeleaf/test");
                registry.addViewController("/l").setViewName("StaffingSystem/login");
                registry.addViewController("/main.html").setViewName("StaffingSystem/dashboard");
            }

            /**
             * 注册拦截器
             * @param registry
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/l","/user/login","/asserts/**","/webjars/**","/bootstrap/**","/myblogStatic/**",
//                                "/jquery/**","/layui/**");
            }
        };

        return  adapter;
    }

    @Bean()
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
