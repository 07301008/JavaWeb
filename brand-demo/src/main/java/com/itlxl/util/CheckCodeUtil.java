package com.itlxl.util;

import java.io.OutputStream;

public class CheckCodeUtil {

    /**
     * 输出随机验证码图片流，并返回验证码值（一般传入输出流，响应response页面端，Web项目用的较多）
     * @param width 图片宽度
     * @param hight 图片高度
     * @param os 输出流
     * @param verifySize 数据长度
     * @return
     */
    /*public static String outputVerifyImage(int width, int hight, OutputStream os,int verifySize){
        String verifyCode = generateVerifyCode(verifySize);
        outputImage(width,hight,os,verifyCode);
        return verifyCode;
    }*/
}
