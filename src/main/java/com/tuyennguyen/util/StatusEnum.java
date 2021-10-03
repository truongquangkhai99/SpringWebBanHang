package com.tuyennguyen.util;

public enum StatusEnum {
	
    SUCCESS(1, "Success!"),
    FAILURE(2, "Failure!"),
    NOT_EXIST(3, "Not Exist!");

    private final int key;
    private final String value;

    StatusEnum(int key, String value) {
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
