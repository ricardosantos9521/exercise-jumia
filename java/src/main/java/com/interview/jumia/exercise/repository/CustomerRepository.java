package com.interview.jumia.exercise.repository;

import com.interview.jumia.exercise.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}