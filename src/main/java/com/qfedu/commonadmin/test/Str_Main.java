package com.qfedu.commonadmin.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *@Author feri
 *@Date Created in 2018/10/13 10:19
 */
public class Str_Main {
    public static void main(String[] args) {
        String str="  发布于 2018-10-13 10:12 ";
        str=str.trim();
        String regex="([\u4e00-\u9fa5]{3}.*)";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(str);

        System.out.println(str.substring(str.indexOf(' ')+1));
        System.out.println(str.matches(regex));

    }
}
