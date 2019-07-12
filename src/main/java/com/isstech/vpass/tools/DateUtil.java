package com.isstech.vpass.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

}
