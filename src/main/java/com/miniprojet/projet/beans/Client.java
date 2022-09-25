package com.miniprojet.projet.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "client" ,
        uniqueConstraints = @UniqueConstraint(name = "unique_name",columnNames = "cin"))
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cin;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String login;
    private String password;

}
