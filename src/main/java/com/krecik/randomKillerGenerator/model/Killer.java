package com.krecik.randomKillerGenerator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter

@Entity
@Table
public class Killer {

    @Id
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String file;

}
