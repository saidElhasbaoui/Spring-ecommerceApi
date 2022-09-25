package com.miniprojet.projet.services.interfaces;

import com.miniprojet.projet.security.AppRole;
import com.miniprojet.projet.security.AppUser;
import com.miniprojet.projet.security.Role;

public interface IaccountService {

    public AppUser findUserByUsername(String username);
    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole r);
    public void addRoleToUser(String username, AppRole ar);

}
