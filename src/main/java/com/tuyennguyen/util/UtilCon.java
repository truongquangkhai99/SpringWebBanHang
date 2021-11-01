package com.tuyennguyen.util;

public class UtilCon {

    public static final String ADMIN               = "admin";
    public static final String CLIENT              = "client";
    public static final String OBJ                 = "obj";
    public static final String PAGE                = "page";
    public static final String PRODUCT             = "product";
    public static final String PRODUCT_EDIT        = "product-edit";
    public static final String PRODUCT_THEM        = "product-them";
    public static final String USER                = "user";
    public static final String USER_EDIT           = "user-edit";
    public static final String USER_THEM           = "user-them";
    public static final String MENU_DONG           = "menu-dong";
    public static final String MENU_DONG_EDIT      = "menu-dong-edit";
    public static final String MENU_DONG_THEM      = "menu-dong-them";

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
        return UtilCon.FOR_SL + UtilCon.ADMIN + UtilCon.FOR_SL + UtilCon.ADMIN + ".html";
    }

    public static String toAdmin(String htmlFileName) {
        String folder = htmlFileName;
        String path = getPathHtmlFileName(folder, htmlFileName, true);

        return path;
    }

    public static String toAdmin(String folder, String htmlFileName) {
        System.out.println(88);
        String path = getPathHtmlFileName(folder, htmlFileName, true);
        System.out.println(path);
        return path;
    }

    public static String toClient(String htmlFileName) {
        String folder = htmlFileName;
        String path = getPathHtmlFileName(folder, htmlFileName, false);
        return path;
    }
    public static String toClient(String folder, String htmlFileName) {
        String path = getPathHtmlFileName(folder, htmlFileName, false);
        return path;
    }

    private static String getPathHtmlFileName(String folder, String htmlFileName, boolean isAdmin) {
        String path = "";
        if (isAdmin == true) {
            path += UtilCon.ADMIN;
        } else {
            path += UtilCon.CLIENT;
        }

        path += UtilCon.FOR_SL + folder;
        path += UtilCon.FOR_SL + htmlFileName;

        return path;
    }

    public static String upperFirstLetter(String str) {
        String firstLetter = str.substring(0, 1).toUpperCase();
        String remainingLetters = str.substring(1, str.length());

        str = firstLetter + remainingLetters;

        return str;
    }
}
