package com.qfedu.commonadmin.test;

import java.util.Timer;
import java.util.TimerTask;

/**
 *@Author feri
 *@Date Created in 2018/10/13 14:32
 */
public class Timer_Main {
    public static void main(String[] args) {
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("不要，不能，不可以，睡觉！！"+(System.currentTimeMillis()/1000));
            }
        },10000,3000);
    }
}
