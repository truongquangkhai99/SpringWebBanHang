package com.tuyennguyen.util;

public enum UtilEnum {

    FORWARD_SLASH(1, "/"),
    BACK_SLASH(2, "\\");

    private final int key;
    private final String value;

    UtilEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }
	
}
