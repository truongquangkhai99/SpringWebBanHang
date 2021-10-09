package com.tuyennguyen.util;

public class UtilFun {

    public static String toAdmin(String toCategory) {
        return UtilCon.FOR_SL + UtilCon.ADMIN + UtilCon.FOR_SL + toCategory;
    }

    public static String toClient(String toCategory) {
        return UtilCon.FOR_SL + UtilCon.CLIENT + UtilCon.FOR_SL + toCategory;
    }

}
