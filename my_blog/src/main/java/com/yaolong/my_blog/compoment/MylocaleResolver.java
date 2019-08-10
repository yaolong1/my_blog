package com.yaolong.my_blog.compoment;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author yaoLong
 * @date 2019/8/10  16:48
 * 区域信息解析器
 */
public class MylocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale = Locale.getDefault();
    if (!StringUtils.isEmpty(l)){
        String[] spilt = l.split("_");
        new Locale(spilt[0],spilt[1]);
    }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
