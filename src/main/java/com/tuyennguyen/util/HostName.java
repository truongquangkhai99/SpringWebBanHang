package com.tuyennguyen.util;

public enum HostName {

    LOCALHOST(1, "localhost:8080");

    private final int key;
    private final String value;

    HostName(int key, String value) {
        this.key = key;
        this.value = value;
    }

}
