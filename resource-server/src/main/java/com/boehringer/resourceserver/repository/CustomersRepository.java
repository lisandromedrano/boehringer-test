package com.boehringer.resourceserver.repository;

import com.boehringer.resourceserver.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends PagingAndSortingRepository<Customer, Integer> {
    Page<Customer> findByVendorUsername(String username, Pageable pageable);
}
