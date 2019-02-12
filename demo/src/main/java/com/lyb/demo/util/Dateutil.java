package com.lyb.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dateutil {
    public static  String getDate(){
        Date nowDate=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(nowDate);
    }

}
