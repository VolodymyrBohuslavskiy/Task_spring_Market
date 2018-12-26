package com.example.demo2.models;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class tovar {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@NonNull
private String  name, about;
private int prise;

    public tovar(String name, String about, int prise) {
        this.name = name;
        this.about = about;
        this.prise = prise;
    }

    public tovar() {
    }
}
