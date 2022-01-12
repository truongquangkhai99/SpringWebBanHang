package com.tuyennguyen.util;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDb {

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

    public void setBackupFolder(String backupFolder) {
        this.backupFolder = backupFolder;
    }

    public static String backupFolder       = "\"D:\\Hoc Lap Trinh\\Spring\\SpringWebBanHang\\src\\main\\resources\\static\\backup_db\\\"";

    public static void backUpDb() {
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String sdfDate = sdf.format(currentDate);
        String FILE_NAME = backupFolder + backup + "_" + sdfDate + ".sql";

        String cmd = "";
        if (UtilCon.EMPTY.equals(password)) {
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
