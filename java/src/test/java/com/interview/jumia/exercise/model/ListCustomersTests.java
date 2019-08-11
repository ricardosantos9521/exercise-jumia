package com.interview.jumia.exercise.model;

import static org.junit.Assert.assertEquals;

import com.interview.jumia.exercise.entity.Customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListCustomersTests {

    List<Customer> customers1;
    List<Customer> customers2;

    public ListCustomersTests() {
        Customer c1 = new Customer(1, "Ricardo Santos", "(237) 697151594");
        Customer c2 = new Customer(2, "Test1", "(258) 849181828");
        Customer c3 = new Customer(3, "Test1", "(251) 9119454961");
        Customer c4 = new Customer(4, "Test1", "(251)9119454961");
        Customer c5 = new Customer(5, "Test1", "(222) jfr");

        customers1 = new LinkedList<Customer>();
        customers1.add(c1);
        customers1.add(c2);
        customers1.add(c3);
        customers1.add(c4);
        customers1.add(c5);

        customers2 = new LinkedList<Customer>();
        customers2.add(c2);
        customers2.add(c5);
    }

    @Test
    public void selectCountries() {

        ListCustomers l1 = new ListCustomers(customers1, 2);

        List<String> countriesToSelect = new LinkedList<String>();
        countriesToSelect.add("portugal");
        countriesToSelect.add("cameroon");
        countriesToSelect.add("ethiopia");

        l1.selectCountries(countriesToSelect);

        assertEquals(2, l1.getList().size());

        ListCustomers l2 = new ListCustomers(customers2, 2);
        l2.selectCountries(countriesToSelect);

        assertEquals(0, l2.getList().size());
    }

    @Test
    public void selectStates() {

        // 1
        ListCustomers l1 = new ListCustomers(customers1, 2);

        List<String> statesToSelect = new LinkedList<String>();
        statesToSelect.add("valid");
        statesToSelect.add("notvalid");

        l1.selectStates(statesToSelect);

        assertEquals(5, l1.getList().size());

        // 2
        ListCustomers l2 = new ListCustomers(customers1, 2);

        List<String> statesToSelect1 = new LinkedList<String>();
        statesToSelect1.add("valid");

        l2.selectStates(statesToSelect1);

        assertEquals(2, l2.getList().size());

        // 3
        ListCustomers l3 = new ListCustomers(customers2, 2);

        l3.selectStates(statesToSelect1);

        assertEquals(1, l3.getList().size());
    }

    @Test
    public void getNumberPages() {
        // 1
        ListCustomers l1 = new ListCustomers(customers1, 2);

        assertEquals(3, l1.getNumberPages());

        // 2
        ListCustomers l2 = new ListCustomers(customers1, 1);

        assertEquals(5, l2.getNumberPages());

        // 3
        ListCustomers l3 = new ListCustomers(customers2, 3);

        assertEquals(1, l3.getNumberPages());
    }

    @Test
    public void getElementsPage() {
        // 1
        ListCustomers l1 = new ListCustomers(customers1, 2);

        assertEquals(customers1.subList(0, 2), l1.getElementsPage(1));
        assertEquals(customers1.subList(2, 4), l1.getElementsPage(2));
        assertEquals(customers1.subList(4, 5), l1.getElementsPage(3));

        // 2
        ListCustomers l2 = new ListCustomers(customers1, 1);

        assertEquals(customers1.subList(0, 1), l2.getElementsPage(6));
        assertEquals(customers1.subList(0, 1), l2.getElementsPage(1));
        assertEquals(customers1.subList(1, 2), l2.getElementsPage(2));
        assertEquals(customers1.subList(2, 3), l2.getElementsPage(3));

        // 3
        ListCustomers l3 = new ListCustomers(customers2, 3);

        assertEquals(customers2.subList(0, 2), l3.getElementsPage(1));
    }

}