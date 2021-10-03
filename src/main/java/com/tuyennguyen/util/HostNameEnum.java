package com.tuyennguyen.util;

public enum HostNameEnum {

    LOCALHOST(1, "http://localhost:8080"),
    BOOTSTRAP(2, "webjars/bootstrap/4.1.1/css/bootstrap.min.css");

    private final int key;
    private final String value;

    HostNameEnum(int key, String value) {
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
