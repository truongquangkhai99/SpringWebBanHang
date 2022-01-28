package com.tuyennguyen.enums;

public enum EnumRole {

    ROLE_ADMIN (1, "ROLE_ADMIN"),

    ROLE_USER (2, "ROLE_USER");

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
