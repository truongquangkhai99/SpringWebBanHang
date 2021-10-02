package com.tuyennguyen.util;

public enum FolderName {
    ADMIN(1, "admin"),
    Client(2, "client");

    private final int key;
    private final String value;

    FolderName(int key, String value) {
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
