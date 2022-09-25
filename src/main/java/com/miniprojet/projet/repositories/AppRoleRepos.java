package com.miniprojet.projet.repositories;

import com.miniprojet.projet.security.AppRole;
import com.miniprojet.projet.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppRoleRepos extends JpaRepository<AppRole, Long> {
    public AppRole findByRole(Role r);
}
