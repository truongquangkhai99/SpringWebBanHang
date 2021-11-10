package com.tuyennguyen.util;

public enum EnumRole {

    ADMIN (1, "Admin"),

    USER (2, "User");

    private int roleId;

    private String roleName;

    EnumRole(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
