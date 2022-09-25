package com.miniprojet.projet.security;

public enum Role {

    ADMIN("ADMIN"), CLIENT("CLIENT"), USER("USER");

    private String role = "";

    Role(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString(){
        return role;
    }


}
