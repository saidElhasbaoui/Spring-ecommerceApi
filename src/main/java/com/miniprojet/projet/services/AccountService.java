package com.miniprojet.projet.services;

import com.miniprojet.projet.exception.BadRequestException;
import com.miniprojet.projet.repositories.AppRoleRepos;
import com.miniprojet.projet.repositories.AppUserRepos;
import com.miniprojet.projet.security.AppRole;
import com.miniprojet.projet.security.AppUser;
import com.miniprojet.projet.security.Role;
import com.miniprojet.projet.services.interfaces.IaccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IaccountService {

    @Autowired
    private AppUserRepos userRepository;

    @Autowired
    private AppRoleRepos appRoleRepos;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public AppUser findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public AppUser saveUser(AppUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public AppRole saveRole(AppRole r) {
        AppRole role =appRoleRepos.findByRole(r.getRole());
        if (role == null ) {
            return appRoleRepos.save(r);
        }
        else {
            throw new BadRequestException("the role is already exist");
        }
    }

    public void addRoleToUser(String username, AppRole ar) {
        AppUser user=userRepository.findByUsername(username);
        //user.addRole(role);
        user.getRoles().add(ar);
        userRepository.save(user);
    }
}
