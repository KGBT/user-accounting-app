
package com.example.user.accounting.models;

public enum RoleProfil {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    String roleProfil;

    private RoleProfil(String roleProfil) {
        this.roleProfil = roleProfil;
    }

    public String getUserProfileType() {
        return roleProfil;
    }

}
