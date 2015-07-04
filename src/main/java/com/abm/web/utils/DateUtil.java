
package com.abm.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DateUtil {

    /**
     * 获取当前时间.(符合支付接口)
     *
     * @return
     */
    public static String getNowday() {
        Date date = new Date();
        SimpleDateFormat sp = new SimpleDateFormat("yyyyMMddHHmmss");
        return sp.format(date);
    }
    
    private static Pattern datePattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");

    public static boolean checkDate(String date){
    	Matcher m = datePattern.matcher(date);
    	if(m.find()){
    		return true;
    	}
    	return false;
    }
    
    
    
}
