package com.krecik.randomKillerGenerator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@DynamicInsert
public class Matches {

    @Id
    @GeneratedValue
    private Integer id;
    private String team1;
    private String team2;
    private String result;
    private String killer;
    private String map;
    private String addon;
    private Integer point1;
    private Integer point2;

    public Matches() {
    }

    public Matches(Integer id,String team1, String team2) {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.result = "Nie rozegrano";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getKiller() {
        return killer;
    }

    public void setKiller(String killer) {
        this.killer = killer;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getAddon() {
        return addon;
    }

    public void setAddon(String addon) {
        this.addon = addon;
    }

    public Integer getPoint1() {
        return point1;
    }

    public void setPoint1(Integer point1) {
        this.point1 = point1;
    }

    public Integer getPoint2() {
        return point2;
    }

    public void setPoint2(Integer point2) {
        this.point2 = point2;
    }
}
