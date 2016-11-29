package com.example.user.day07_xiangmu04.Business;

import java.util.Random;

/**
 * Created by user on 2016/11/29.
 * 业务类
 * 1.判断选择的游戏等级(界面跳转，传参)
 * 2.出题
 * 3.比对
 * 4.返回结果（界面跳转，传参）
 * 5.设置主页胜利或失败的显示图片
 *
 */

public class Guess {
    //设置等级
    public static final String  LEVEL= "LEVEL";
    public static final String  LEVEL_LOW_S= "LEVEL_LOW";
    public static final String  LEVEL_HIGH_S= "LEVEL_HIGH";
    //设置返回码
    public static final int RESULT_LOW = 2;
    public static final int RESULT_HIGH= 3;
    //设置请求码
    public static final int REQUEST_LOW = 0;
    public static final int REQUEST_HIGH = 1;
//设置随机数
   private Random r=new Random();
    public Guess() {

    }
//    //等级判断 int  返回随机数
    public int Level(String s){
        //i根据不同的游戏等级进行赋值
        int i=1;//存放产生的随机数
        s="";//等级
        //地等级
        if (s.equals(LEVEL_LOW_S)){
            i=r.nextInt(50);
        }
        //高等级
        if (s.equals(LEVEL_HIGH_S)){
            i=r.nextInt(100);
        }
        return i;
    }
    //3.比对  返回胜负标志
    public String Check(String input,Integer r){
        String s="";//存放胜负标志
        int shuru=Integer.parseInt(input);
        if(shuru==r)
        {
            s="相等";
        }
        else if(shuru>r)
        {
            s="大于";
        }
        else if(shuru<r)
        {
            s="小于";
        }
        return s;
    }

    public Random getR(String s) {
        return r;
    }

    public void setR(Random r) {
        this.r = r;
    }


    public static String getLevelLowS() {
        return LEVEL_LOW_S;
    }

    public static int getResultHigh() {
        return RESULT_HIGH;
    }

    public static int getResultLow() {
        return RESULT_LOW;
    }

    public static String getLevelHighS() {
        return LEVEL_HIGH_S;
    }

    public static int getRequestHigh() {
        return REQUEST_HIGH;
    }

    public static int getRequestLow() {
        return REQUEST_LOW;
    }


}
