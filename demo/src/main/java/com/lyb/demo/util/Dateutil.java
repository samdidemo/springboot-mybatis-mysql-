package com.lyb.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取当前时间工具类，并转化为相应的格式
 * lyb
 */
public class Dateutil {
    public static  String getDate(){
        Date nowDate=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(nowDate);
    }
    public String test(){
        return "ssss";
    }

}
