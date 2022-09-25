package com.miniprojet.projet.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationForm {

    public enum Role {
        CLIENT("CLIENT"),
        ADMIN("ADMIN");

        private String role = "";

        Role (String role){
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
    private String nom = null;
    private String prenom = null;
    private String username;
    private String password;
    private String repassword;
    private Role role;

}
