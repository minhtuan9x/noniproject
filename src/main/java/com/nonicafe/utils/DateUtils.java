package com.nonicafe.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DateUtils {
    public static String toDateStr(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(Objects.isNull(date)?new Date():date);
    }
}
