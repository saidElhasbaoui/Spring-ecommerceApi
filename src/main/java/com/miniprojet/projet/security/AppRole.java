package com.miniprojet.projet.security;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity


public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAppRole;

    @Enumerated(EnumType.STRING)
    private Role role;

}
