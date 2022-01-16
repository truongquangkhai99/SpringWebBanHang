package com.tuyennguyen.util;

import com.tuyennguyen.entity.MenuDong;
import com.tuyennguyen.entity.Product;
import com.tuyennguyen.entity.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.text.DecimalFormat;

@Configuration
public class UtilCon {

    /**
     * String imageFolder
     */
    public static String imageFolder;

    @Value("${imageFolder}")
    public void setImageFolder(String imageFolder) {
        this.imageFolder = imageFolder;
    }

    public static String localhost;

    @Value("${localhost}")
    public void setLocalhost(String localhost) {
        this.localhost = localhost;
    }

    public static final String OBJ           = "obj";
    public static final String EMPTY         = "";
    public static String PAGE                = "page";
    /**
     * Product constant
     */
    public static String PRODUCT             = "product";
    public static String PRODUCT_EDIT        = "product-edit";
    public static String PRODUCT_THEM        = "product-them";
    /**
     * User constant
     */
    public static String USER                = "user";
    public static String USER_EDIT           = "user-edit";
    public static String USER_THEM           = "user-them";
    /**
     * Menu động constant
     */
    public static String MENU_DONG           = "menu-dong";
    public static String MENU_DONG_EDIT      = "menu-dong-edit";
    public static String MENU_DONG_THEM      = "menu-dong-them";
    /**
     * Ý kiến constant
     */
    public static String Y_KIEN              = "y-kien";

    public static String SETTING_EDIT        = "setting-edit";
    public static String REDICRECT           = "redirect:";

    public static String FOR_SL              = "/";
    public static String BAC_SL              = "\\";
    public static String Dash                = "-";
    public static String PATH_TO_STATIC      = "src/main/resources/static";
    public static String BOOTSTRAP_CSS       = "webjars/bootstrap/4.1.1/css/bootstrap.min.css";
    public static String BOOTSTRAP_JS        = "webjars/bootstrap/4.1.1/js/bootstrap.js";
    public static String JQUERY              = "webjars/jquery/3.3.1-1/jquery.js";

    // menu parent
    public static int PARENT                 = 1;
    // menu child
    public static int NOT_PARENT             = 0;
    public static int VISIBLE                = 1;
    public static int INVISIBLE              = 0;

    // product favourite
    public static int FAVOURITE              = 1;

    // all item of product
    public static int ALL_ITEM               = 1;
    // favoutire item of product
    public static int FAVOURITE_ITEM         = 2;
    // invisible item of product
    public static int INVISIBLE_ITEM         = 3;
    // invisible item of product
    public static int VISIBLE_ITEM           = 4;


    public static String toAdmin(String folder, String htmlFileName) {
        String path = getPathHtmlFileName(folder, htmlFileName, true);

        return path;
    }

    public static String toClient(String htmlFileName) {
        String path = "client/" + htmlFileName;
        return path;
    }

    public static String toClient() {
        return UtilCon.REDICRECT + localhost + "/home";
    }

    public static String toAdmin(String htmlFileName) {
        String folder = htmlFileName;
        String path = getPathHtmlFileName(folder, htmlFileName, true);

        return path;
    }
    private static String getPathHtmlFileName(String folder, String htmlFileName, boolean isAdmin) {
        String path = "";
        return path;
    }

    public static String createLinkFromMenuName(String menuName) {
        String menuLink = "";
        menuLink = menuName.toLowerCase().trim().replaceAll("\\s{1,}","-");
        return menuLink;
    }

    public static Product trimObject(Product obj) {
        obj.setProductName(obj.getProductName().trim());
        obj.setDescription(obj.getDescription().trim());

        return obj;
    }

    public static User trimObject(User obj) {
        obj.setUsername(obj.getUsername().trim());
        obj.setFullName(obj.getFullName().trim());
        obj.setRole(obj.getRole().trim());

        return obj;
    }

    public static MenuDong trimObject(MenuDong obj) {
        obj.setMenuName(obj.getMenuName().trim());
        obj.setDescription(obj.getDescription().trim());

        return obj;
    }

    public static String formatMoney(String money) {
        double amount = Double.parseDouble(money);
        DecimalFormat formatter = new DecimalFormat("#,###");

        return formatter.format(amount).replaceAll(",", ".");
    }

    public static void logData(Logger log, Exception e) {
        log.error("", e);
    }

}
