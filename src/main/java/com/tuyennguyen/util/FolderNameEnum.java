package com.tuyennguyen.util;

public enum FolderNameEnum {
    ADMIN(1, "admin"),
    Client(2, "client");

    private final int key;
    private final String value;

    FolderNameEnum(int key, String value) {
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
