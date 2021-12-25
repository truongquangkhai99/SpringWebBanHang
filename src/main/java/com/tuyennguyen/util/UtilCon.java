package com.tuyennguyen.util;

import com.tuyennguyen.entity.MenuDong;
import com.tuyennguyen.entity.Product;
import com.tuyennguyen.entity.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class UtilCon {

    /**
     * String backup
     */
    private static String backup;

    @Value("${backup}")
    public void setBackUp(String backup) {
        this.backup = backup;
    }

    /**
     * String dbName
     */
    public static String dbName;

    @Value("${dbName}")
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    /**
     * String username
     */
    public static String username;

    @Value("${user_name}")
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * String password
     */
    public static String password;

    @Value("${password}")
    public void setPassword(String password) {
        this.password = password;
    }

    public void setBackupFolder(String backupFolder) {
        this.backupFolder = backupFolder;
    }

    /**
     * String admin
     */
    public static String admin;

    @Value("${admin}")
    public void setAdmin(String admin) {
        this.admin = admin;
    }

    /**
     * String client
     */
    public static String client;

    @Value("${client}")
    public void setClient(String client) {
        this.client = client;
    }

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

    public static String backupFolder       = "\"D:\\Hoc Lap Trinh\\Spring\\SpringWebBanHang\\src\\main\\resources\\static\\backup_db\\\"";

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

    public static String goAdmin() {
        return UtilCon.FOR_SL + admin + UtilCon.FOR_SL + admin + ".html";
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

    public static String toClient() {
        return UtilCon.REDICRECT + localhost + "/home";
    }

    private static String getPathHtmlFileName(String folder, String htmlFileName, boolean isAdmin) {
        String path = "";
        if (isAdmin == true) {
            path += admin;
        } else {
            path += client;
        }

        path += UtilCon.FOR_SL + folder;
        path += UtilCon.FOR_SL + htmlFileName;

        return path;
    }

    public static String createLinkFromMenuName(String menuName) {
        String menuLink = "";
        System.out.println(menuName);
        menuLink = menuName.toLowerCase().trim().replaceAll("\\s{1,}","-");
        System.out.println(menuLink);
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

    public static void print(String sql) {
        System.out.println(sql.replaceAll("\\s{2,}"," "));
    }

    public static void logData(Logger log, Exception e) {
        log.error("", e);
        System.out.println("");
        System.out.println("====");
        System.out.println(e.getClass());
        System.out.println(e.getMessage());
        System.out.println("====");
        System.out.println("");
    }

    public static void backUpDb() {
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String sdfDate = sdf.format(currentDate);
        String FILE_NAME = backupFolder + backup + "_" + sdfDate + ".sql";

        String cmd = "";
        if (EMPTY.equals(password)) {
            cmd ="\"" + "C:\\xampp\\mysql\\bin\\mysqldump.exe " + " \" -u" + username + " --databases " + dbName + " > " + FILE_NAME;
        } else {
            cmd ="\"" + "C:\\xampp\\mysql\\bin\\mysqldump.exe " + " \" -u" + username + " -p" + password + " --databases " + dbName + " > " + FILE_NAME;
        }

        try {
            String[] command = {"cmd", "/c", cmd};
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
