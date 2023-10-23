package com.workintech.burgershop.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "burger", schema = "s18d1")

public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double  price;

    @Column(name = "is_vegan")
    private boolean isVegan; 

    @Column(name = "bread_type")
    private String breadType;
    private List<String> contents;
}
