package com.tuyennguyen.util;

import java.io.File;

public class UtilPath {

    public static String toAdmin() {
        return "/admin/admin.html";
    }

    public static String getPathResource() {
        File resourcesPath = new File("resources");
        String pathResource = resourcesPath.getAbsolutePath();

        return pathResource;
    }

}
