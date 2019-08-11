package com.interview.jumia.exercise.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.interview.jumia.exercise.countries.Countries;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private String name;
    private String phone;

    public Customer() {
    }

    public Customer(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCode() {
        String[] spPhone = phone.split(" ");
        if (spPhone.length == 2) {
            return spPhone[0].replace("(", "+").replace(")", "");
        }
        return null;
    }

    public String getNumber() {
        String[] spPhone = phone.split(" ");
        if (spPhone.length == 2) {
            return spPhone[1];
        }
        return null;
    }

    public String getCountryName() {
        return Countries.getCountryName(getCode());
    }

    public Boolean getState() {
        return Countries.isValidNumber(getCode(), getPhone());
    }
}