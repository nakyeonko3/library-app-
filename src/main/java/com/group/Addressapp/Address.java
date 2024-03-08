package com.group.Addressapp;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    private String street;

    @OneToOne(mappedBy = "address")
    private Person person;

    public void setAddress(Person person) {
    this.person = person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
