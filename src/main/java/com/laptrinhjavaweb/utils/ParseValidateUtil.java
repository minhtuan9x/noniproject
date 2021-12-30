package com.laptrinhjavaweb.utils;

public class ParseValidateUtil {
    public static Integer parseInt(Object obj){
        try {
            return Integer.parseInt((String) obj);
        }catch (Exception e){
            return null;
        }
    }
}
