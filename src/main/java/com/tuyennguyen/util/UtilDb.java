package com.tuyennguyen.util;

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

    private static String[] createCommandBackup(String pathDb, String folder, String prefix, String suffix) {
        String osName = System.getProperty("os.name");
        String cmd = "";
        String[] command;
        // if Operation System is Linux
        if ("Linux".equals(osName)) {
            // set path
            if (UtilCon.EMPTY.equals(password)) {
                cmd = "/opt/lampp/bin/mysqldump " + " -u" + username + " --databases " + dbName + " > " + pathDb + folder + prefix + "_" + suffix + ".sql";
            } else {
                cmd = "/opt/lampp/bin/mysqldump " + " -u" + username + " -p" + password + " --databases " + dbName + " > " + pathDb + folder + "/" + prefix + "_" + suffix + ".sql";
            }

            // set command
            command = new String[]{"/bin/sh", "-c", cmd};
        } else {
            // if Operation System is Window
            if (UtilCon.EMPTY.equals(password)) {
                cmd ="\"" + "C:\\xampp\\mysql\\bin\\mysqldump.exe " + " \" -u" + username + " --databases " + dbName + " > \"" + pathDb + "\\" + folder + "\\" + prefix + "_" + suffix + ".sql";
            } else {
                System.out.println(2);
                cmd ="\"" + "C:\\xampp\\mysql\\bin\\mysqldump.exe " + " \" -u" + username + " -p" + password + " --databases " + dbName + " > \"" + pathDb + "\\" + folder + "\\" + prefix + "_" + suffix + ".sql";
            }

            // set command
            command = new String[]{"cmd", "/c", cmd};
        }
        return command;
    }

    public static void backUpDb() {
        String pathDb = UtilPath.getPathResource();
        pathDb = pathDb.replaceAll("resources", "src\\\\main\\\\resources\\\\static");

        dbName = "spring_web_ban_hang";
        username = "root";
        password = "";
        String[] command = createCommandBackup(pathDb, "backup_db", "BU" , UtilDate.getYYYYMMDD_HHMMSS());

        try {
            Runtime.getRuntime().exec(command);
            // log success
            log.debug("Back up database successful!" +
                      "\n\tThông báo thành công thì có thể thành công thật hoặc không" +
                      "\n\tCòn thông báo backup thất bại thì chắc chắn là thất bại");
        } catch (IOException e) {
            // log error
            log.error(e.getMessage());
            log.error("Back up database error!");
        }
    }

}
