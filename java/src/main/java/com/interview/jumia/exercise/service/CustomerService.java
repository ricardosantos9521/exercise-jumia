package com.interview.jumia.exercise.service;

import java.util.List;

import com.interview.jumia.exercise.entity.Customer;
import com.interview.jumia.exercise.model.ListCustomers;
import com.interview.jumia.exercise.model.Page;
import com.interview.jumia.exercise.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Page filter(int page, List<String> countries, List<String> states) {
        ListCustomers list = new ListCustomers(customerRepository.findAll());

        list.selectStates(states);

        list.selectCountries(countries);

        int numberPages = list.getNumberPages();

        return new Page(page, numberPages, list.getElementsPage(page));
    }

}