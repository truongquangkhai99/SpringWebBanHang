package com.tuyennguyen.util;

public class UtilCon {

    public static final String ADMIN               = "admin";
    public static final String CLIENT              = "client";
    public static final String OBJ                 = "obj";

    public static final String FOR_SL              = "/";
    public static final String BAC_SL              = "\\";
    public static final String Dash                = "-";
    public static final String BOOTSTRAP           = "webjars/bootstrap/4.1.1/css/bootstrap.min.css";


    public static String toAdmin() {
        return UtilCon.FOR_SL + UtilCon.ADMIN;
    }

    public static String toAdmin(String category) {
        return UtilCon.FOR_SL + UtilCon.ADMIN + UtilCon.FOR_SL + category;
    }

    public static String toClient(String toCategory) {
        return UtilCon.FOR_SL + UtilCon.CLIENT + UtilCon.FOR_SL + toCategory;
    }

    public static String upperFirstLetter(String str) {
        String firstLetter = str.substring(0, 1).toUpperCase();
        String remainingLetters = str.substring(1, str.length());

        str = firstLetter + remainingLetters;

        return str;
    }
}
