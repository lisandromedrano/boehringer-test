package com.boehringer.resourceserver.controller;

import com.boehringer.resourceserver.model.Customer;
import com.boehringer.resourceserver.model.Order;
import com.boehringer.resourceserver.repository.CustomersRepository;
import com.boehringer.resourceserver.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceServerController {


    @Autowired
    private CustomersRepository customersRepository;
    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping(value = "/customers")
    public Page<Customer> getCustomers(Pageable pageable) {
        return customersRepository.findByVendorUsername(getUser(), pageable);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Customer getCustomer(@PathVariable Integer id, Pageable pageable) {
        String user = getUser();
        return customersRepository.findById(id).orElse(null);
    }


    @RequestMapping(value = "/orders", method = RequestMethod.GET, produces = {"application/JSON"})
    public Page<Order> getOrders(Pageable pageable) {
        return ordersRepository.findByVendorUsername(getUser(), pageable);
    }

    private String getUser() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

}