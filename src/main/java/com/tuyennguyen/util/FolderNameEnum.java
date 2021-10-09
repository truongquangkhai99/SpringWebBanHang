package com.tuyennguyen.util;

public enum FolderNameEnum {
    folder1(1, "folder1"),
    folder2(2, "folder2");

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
