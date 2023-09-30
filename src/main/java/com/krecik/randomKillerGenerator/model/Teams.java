package com.krecik.randomKillerGenerator.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Teams {

    @Id
    private Integer id;
    private String name;


    public Teams(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Teams() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
