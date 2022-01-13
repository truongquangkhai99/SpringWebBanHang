package com.tuyennguyen.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDate {

    private static String getCurrentDate(String format) {
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String strDate = sdf.format(currentDate);
        return strDate;
    }

    public static String getYYYYMMDD_HHMMSS() {
        return getCurrentDate("yyyy_MM_dd_HHmmss");
    }

    public static String getYYYYMMDD() {
        return getCurrentDate("yyyy_MM_dd");
    }

    public static String getHHMMSS() {
        return getCurrentDate("HHmmss");
    }

}
