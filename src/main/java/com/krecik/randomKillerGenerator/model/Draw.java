package com.krecik.randomKillerGenerator.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Draw {
    private int idKiller;
    private int idMap;
    private String addonName;
}
