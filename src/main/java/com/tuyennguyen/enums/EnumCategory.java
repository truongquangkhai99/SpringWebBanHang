package com.tuyennguyen.enums;

public enum EnumCategory {

    TECHNICAL (1, "TECHNICAL"),

    BUSINESS (2, "BUSINESS");

    private int id;

    private String name;

    EnumCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
