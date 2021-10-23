package com.tuyennguyen.util;

public class UtilCon {

    public static final String ADMIN               = "admin";
    public static final String CLIENT              = "client";
    public static final String OBJ                 = "obj";

    public static final String FOR_SL              = "/";
    public static final String BAC_SL              = "\\";
    public static final String Dash                = "-";
    public static final String BOOTSTRAP_CSS       = "webjars/bootstrap/4.1.1/css/bootstrap.min.css";
    public static final String BOOTSTRAP_JS        = "webjars/bootstrap/4.1.1/js/bootstrap.js";
    public static final String JQUERY              = "webjars/jquery/3.3.1-1/jquery.js";

    public static final int PARENT                 = 1;
    public static final int NOT_PARENT             = 0;
    public static final int VISIBLE                = 1;
    public static final int NOT_VISIBLE            = 0;


    public static String toAdmin() {
        return UtilCon.FOR_SL + UtilCon.ADMIN;
    }

    public static String toAdmin(String category) {
        if (category.equals(UtilCon.ADMIN)) {
            return UtilCon.FOR_SL + UtilCon.ADMIN + UtilCon.FOR_SL + category;
        } else {
            return UtilCon.FOR_SL + UtilCon.ADMIN + UtilCon.FOR_SL + category + UtilCon.FOR_SL + category;
        }
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
