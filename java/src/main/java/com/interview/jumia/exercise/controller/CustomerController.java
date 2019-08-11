package com.interview.jumia.exercise.controller;

import java.util.*;

import com.interview.jumia.exercise.countries.Countries;
import com.interview.jumia.exercise.model.Page;
import com.interview.jumia.exercise.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/countries")
    public ResponseEntity<List<String>> getCountries() {
        return new ResponseEntity<>(Countries.getCountryNames(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page> getCustomers(@RequestParam(value = "countries", required = false) String countries,
            @RequestParam(value = "states", required = false) String states,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page) {

        List<String> listCountries = null;
        List<String> listStates = null;

        if (countries != null) {
            String[] countriesStr = countries.split(",");
            if (countriesStr.length > 0) {
                listCountries = Arrays.asList(countriesStr);
            }
        }

        if (states != null) {
            String[] statesStr = states.split(",");
            if (statesStr.length > 0) {
                listStates = Arrays.asList(statesStr);
            }
        }

        return new ResponseEntity<>(customerService.filter(page, listCountries, listStates), HttpStatus.OK);
    }
}