package com.test.demo.util;

public class CommonUtils {

    public static boolean isEmpty(String anyString) {
        if (anyString == null || anyString.equals("")) {
            return true;
        }else {
            return false;
        }
    }
}
