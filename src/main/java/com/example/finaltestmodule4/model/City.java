package com.example.finaltestmodule4.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 55, name = "city_name")
//    @NotEmpty(message = "Name must not be empty")
//    @Size(min = 6, max=15, message = "Name's length from 6 to 15 characters")
    private String name;

    @Column(length = 55, name = "area")
    private double area;

    @Column(length = 55, name = "population")
    private double population;

    @Column(length = 55, name = "gpa")
    private double GPA;

    @Lob
    private String description;

    @ManyToOne
    private National national;


}
