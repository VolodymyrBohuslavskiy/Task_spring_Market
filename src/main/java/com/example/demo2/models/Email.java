package com.example.demo2.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@ToString(exclude = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    String adres;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    User user;

    public Email(String adres, User user) {
        this.adres = adres;
        this.user = user;
    }

    public Email() {
    }
}
