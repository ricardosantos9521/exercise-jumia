package com.interview.jumia.exercise.model;

import java.util.List;

import com.interview.jumia.exercise.entity.Customer;

public class ListCustomers {
    private List<Customer> customers;
    public int numberCustomersByPage = 30;

    public ListCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public ListCustomers(List<Customer> customers, int numberCustomersByPage) {
        this.customers = customers;
        this.numberCustomersByPage = numberCustomersByPage;
    }

    public void selectCountries(List<String> countries) {
        if (countries != null)
            customers.removeIf(x -> !countries.contains(x.getCountryName().toLowerCase()));
    }

    public void selectStates(List<String> states) {
        if (states != null)
            customers.removeIf(x -> !states.contains((x.getState()) ? "valid" : "notvalid"));
    }

    public int getNumberPages() {
        return (customers.size() / numberCustomersByPage) + ((customers.size() % numberCustomersByPage == 0) ? 0 : 1);
    }

    public List<Customer> getList() {
        return customers;
    }

    public List<Customer> getElementsPage(int page) {
        if ((page - 1) * numberCustomersByPage < customers.size()) {
            if (page * numberCustomersByPage <= customers.size()) {
                return customers.subList((page - 1) * numberCustomersByPage, page * numberCustomersByPage);
            } else {
                return customers.subList((page - 1) * numberCustomersByPage, customers.size());
            }
        } else {
            if (customers.size() > numberCustomersByPage) {
                return customers.subList(0, numberCustomersByPage);
            } else {
                return customers.subList(0, customers.size());
            }
        }
    }
}