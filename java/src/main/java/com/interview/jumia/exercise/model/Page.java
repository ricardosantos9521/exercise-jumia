package com.interview.jumia.exercise.model;

import java.util.List;

import com.interview.jumia.exercise.entity.Customer;

public class Page {
    public int page;
    public int numberPages;
    public List<Customer> listCustomers;

    public Page(int page, int numberPages, List<Customer> listCustomers) {
        this.page = page;
        this.numberPages = numberPages;
        this.listCustomers = listCustomers;
    }
}