//package com.yaolong.my_blog.config;
//
//import sun.misc.BASE64Encoder;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
///**
// * @Author: 殷跃龙
// * @Description:
// * @Date: Create in 12:26 2019/8/8
// */
//public class ImgToBase64 {
//
//    public String getBaseImg(String imgPath) throws CustomExceptio {
//
//        InputStream in = null;
//        byte[] data = null;
//        try {
//            in = new FileInputStream(WorkConstant.PROIMAGE_DIR_REALNAME + "/webSystem/" + imgPath);
//            data = new byte[in.available()];
//            in.read(data);
//            in.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //进行Base64编码
//        BASE64Encoder encoder = new BASE64Encoder();
//        return encoder.encode(data);
//    }
//}
//
