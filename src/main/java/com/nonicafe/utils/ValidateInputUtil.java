package com.nonicafe.utils;

import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.util.List;

public class ValidateInputUtil {
    public static boolean isValid(Object obj){
        if(obj==null||obj.toString().equals(""))
            return false;
        if(obj instanceof Integer)
            return (Integer) obj != 0;
        if(obj instanceof List)
            return ((List<?>) obj).size()>0;
        return true;
    }
    public static boolean isFileValid(MultipartFile file){
        return !file.isEmpty();
    }
    public static boolean isFileValid(MultipartFile[] files){
        int unValid = 0;
        for(MultipartFile item : files){
            if(!isFileValid(item))
                unValid++;
        }
        return unValid!=4;
    }
    public static boolean isEmptyObject(Object obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
        int unValid=0;
        for(Field item:fields){
            item.setAccessible(true);
            if(!isValid((item.get(obj))))
                unValid++;
        }
        return unValid==fields.length;
    }
}
