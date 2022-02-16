package com.example.finaltestmodule4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class National {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 55, name = "national_name")
    private String name;
}
