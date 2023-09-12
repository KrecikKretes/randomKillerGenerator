package com.krecik.randomKillerGenerator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Killers {

    @Id
    private Integer id;

    private String name;

    private String file;

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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
