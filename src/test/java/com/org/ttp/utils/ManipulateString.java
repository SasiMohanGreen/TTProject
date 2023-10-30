package com.org.ttp.utils;

import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;

public class ManipulateString {
    public static void main(String[] str){
        String s = "[TC01] To validate Technical Test Form -- Positive Scenario";

        System.out.println(StringUtils.substringBetween(s,"[","]"));

        String ss = "Sports,Music";
        String[] splitString =StringUtils.split(ss,",");
    }
}
