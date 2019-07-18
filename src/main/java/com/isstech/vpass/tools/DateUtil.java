package com.isstech.vpass.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * Date==>string
     *
     * @param date
     * @param reg
     * @return
     * @throws ParseException
     */
    public static String formatDate(Date date, String reg) {
        SimpleDateFormat sdf = new SimpleDateFormat(reg);
        return sdf.format(date);
    }

    /**
     * string==>Date
     *
     * @param strDate
     * @param reg
     * @return
     * @throws ParseException
     */
    public static Date parse(String strDate, String reg)
            throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(reg);
        return sdf.parse(strDate);
    }

    /**
     * 获取参数设置的时间
     * @param filed 类型 exp:Calendar.MINUTE 5分钟前
     * @param amount 时间值 exp: -5
     * @return 时间戳
     */
    public static Long getTimeByParam(int filed, int amount){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(filed, amount);
        Date beforeD = beforeTime.getTime();
//        String time = sdf.format(beforeD);
        return beforeD.getTime();
    }

}
