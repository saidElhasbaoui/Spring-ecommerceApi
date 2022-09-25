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
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private String unity;
    private Double quantity ;

    @ManyToOne
    @JoinColumn(name = "corporate")
    private Corporate corporate ;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category ;

}
