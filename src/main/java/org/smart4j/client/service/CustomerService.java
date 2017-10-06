package org.smart4j.client.service;

import org.smart4j.client.model.Customer;
import org.smart4j.framework.annotation.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuezhang on 17/10/6.
 */
@Service
public class CustomerService {


    public List<Customer> getCustomerList() {

        List<Customer> customers = new ArrayList<>();

        Customer c1 = new Customer();
        c1.setId(1L);
        c1.setName("customer1");
        c1.setContact("Jack");
        c1.setTelephone("13918648191");
        c1.setEmail("jack@gmail.com");

        Customer c2 = new Customer();
        c2.setId(2L);
        c2.setName("customer2");
        c2.setContact("Rose");
        c2.setTelephone("13918648192");
        c2.setEmail("rose@gmail.com");

        customers.add(c1);
        customers.add(c2);

        return customers;
    }
}
