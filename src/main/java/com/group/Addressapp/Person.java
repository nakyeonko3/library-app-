package com.group.Addressapp;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Address address;

    public void setAddress(Address address) {
        this.address = address;
        address.setPerson(this);
    }
}
