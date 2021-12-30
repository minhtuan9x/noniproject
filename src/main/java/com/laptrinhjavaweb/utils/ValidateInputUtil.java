package com.laptrinhjavaweb.utils;

public class ValidateInputUtil {
    public static boolean isValid(Object obj){
        if(obj==null||obj.toString().equals(""))
            return false;
        if(obj instanceof Integer)
            return (Integer) obj != 0;
        return true;
    }
}
