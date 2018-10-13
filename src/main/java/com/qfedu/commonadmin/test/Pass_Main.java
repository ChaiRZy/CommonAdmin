package com.qfedu.commonadmin.test;

import com.qfedu.commonadmin.common.PassUtil;

/**
 *@Author feri
 *@Date Created in 2018/10/13 08:43
 */
public class Pass_Main {
    public static void main(String[] args) {
        System.out.println(PassUtil.md5("admin"));
    }
}
