package com.tuyennguyen.util;

import com.tuyennguyen.controller.ProductController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class UtilDb {
    private static Logger log = LoggerFactory.getLogger(UtilDb.class);

    /**
     * String backup
     */
    private static String backup;
    @Value("${backup}")
    public void setBackUp(String backup) {
        this.backup = backup;
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
    /**
     * String dbName
     */
    public static String dbName;
    @Value("${dbName}")
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    private static String[] getInfoByOsName(String fileName) {
        String osName = System.getProperty("os.name");
        String cmd = "";
        String path = "";
        String[] command;
        // if Operation System is Linux
        if ("Linux".equals(osName)) {
            // set path
            path = "/home/tuyennv/Desktop/";
            if (UtilCon.EMPTY.equals(password)) {
                cmd ="" + "/opt/lampp/bin/mysqldump " + " -u" + username + " --databases " + dbName + " > " + path + fileName;
            } else {
                cmd ="\"" + "C:\\xampp\\mysql\\bin\\mysqldump.exe " + " \" -u" + username + " -p" + password + " --databases " + dbName + " > " + path + fileName;
            }

            // set command
            command = new String[]{"/bin/sh", "-c", cmd};
        } else {
            // if Operation System is Window
            // set path
            path = "\"D:\\Hoc Lap Trinh\\Spring\\SpringWebBanHang\\src\\main\\resources\\static\\backup_db\\\"";

            if (UtilCon.EMPTY.equals(password)) {
                cmd ="\"" + "C:\\xampp\\mysql\\bin\\mysqldump.exe " + " \" -u" + username + " --databases " + dbName + " > " + path + fileName;
            } else {
                cmd ="\"" + "C:\\xampp\\mysql\\bin\\mysqldump.exe " + " \" -u" + username + " --databases " + dbName + " > " + path + fileName;
            }
            command = new String[]{"cmd", "/c", cmd};
        }
        // set command
        return command;
    }

    public static void backUpDb() {
        String strDate = UtilDate.getYYYYMMDD_HHMMSS();
        backup = "BU";
        String fileName = backup + "_" + strDate + ".sql";

        dbName = "spring_web_ban_hang";
        username = "root";
        password = "";
        String[] command = getInfoByOsName(fileName);

        try {
            Runtime.getRuntime().exec(command);
            // log info
            log.debug("Back up database successful!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            // log error
            log.error("Back up database error!");
        }
    }

}
