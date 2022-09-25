package com.miniprojet.projet.repositories;

import com.miniprojet.projet.security.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepos extends JpaRepository<AppUser, Long> {
    public AppUser findByUsername(String username);
}
