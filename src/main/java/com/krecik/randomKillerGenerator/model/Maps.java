package com.krecik.randomKillerGenerator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Maps {

    @Id
    private Integer id;
    private String name;
    private String file;

    public Maps(Integer id, String name, String file) {
        this.id = id;
        this.name = name;
        this.file = file;
    }

    public Maps() {
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Maps{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", file='" + file + '\'' +
                '}';
    }
}
