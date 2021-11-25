package com.tuyennguyen.util;

import com.tuyennguyen.entity.MenuDong;
import com.tuyennguyen.entity.Product;
import com.tuyennguyen.entity.User;

public class UtilCon {

    public static final String ADMIN               = "admin";
    public static final String CLIENT              = "client";
    public static final String OBJ                 = "obj";
    public static final String EMPTY               = "";
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
    public static final String PATH_TO_STATIC      = "src/main/resources/static";
    public static final String IMAGE_FOLDER        = "image";
    public static final String BOOTSTRAP_CSS       = "webjars/bootstrap/4.1.1/css/bootstrap.min.css";
    public static final String BOOTSTRAP_JS        = "webjars/bootstrap/4.1.1/js/bootstrap.js";
    public static final String JQUERY              = "webjars/jquery/3.3.1-1/jquery.js";

    public static final int PARENT                 = 1;
    public static final int NOT_PARENT             = 0;
    public static final int VISIBLE                = 1;
    public static final int INVISIBLE              = 0;
    public static final int FAVOURITE              = 1;

    public static String toAdmin() {
        return UtilCon.FOR_SL + UtilCon.ADMIN + UtilCon.FOR_SL + UtilCon.ADMIN + ".html";
    }

    public static String toAdmin(String htmlFileName) {
        String folder = htmlFileName;
        String path = getPathHtmlFileName(folder, htmlFileName, true);

        return path;
    }

    public static String toAdmin(String folder, String htmlFileName) {
        String path = getPathHtmlFileName(folder, htmlFileName, true);
        System.out.println(path);
        return path;
    }

    public static String toClient(String htmlFileName) {
        String path = "client/" + htmlFileName;
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

    public static String createLinkFromMenuName(String menuName) {
        String menuLink = "";
        menuLink = menuName.trim().replaceAll("\\s{1,}","-");
        return menuLink;
    }

    public static Product trimObject(Product obj) {
        obj.setProductName(obj.getProductName().trim());
        obj.setDescription(obj.getDescription().trim());

        return obj;
    }

    public static User trimObject(User obj) {
        obj.setUsername(obj.getUsername().trim());
        obj.setPassword(obj.getPassword().trim());
        obj.setFullName(obj.getFullName().trim());
        obj.setRole(obj.getRole().trim());

        return obj;
    }

    public static MenuDong trimObject(MenuDong obj) {
        obj.setMenuName(obj.getMenuName().trim());
        obj.setDescription(obj.getDescription().trim());

        return obj;
    }
}
