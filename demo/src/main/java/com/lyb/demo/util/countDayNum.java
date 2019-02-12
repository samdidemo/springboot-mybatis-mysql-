package com.lyb.demo.util;

/**
 * 获取用户入住总天数
 * String转为int
 * lyb
 */
public class countDayNum {
    public  static int count(String intTime,String outTime){
        String[] intsplit=intTime.split("/");
        String[] outsplit=outTime.split("/");
        int timeNum=Integer.parseInt(outsplit[1])-Integer.parseInt(intsplit[1]);
        if(timeNum==0){
            System.out.println("不能为同一天");
        }else if(timeNum<0) {
            System.out.println("非法日期");
        }
        return timeNum;
    }
}
