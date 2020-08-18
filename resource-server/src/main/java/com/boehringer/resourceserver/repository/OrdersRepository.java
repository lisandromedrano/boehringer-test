package com.boehringer.resourceserver.repository;

import com.boehringer.resourceserver.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends PagingAndSortingRepository<Order, Integer> {
    Page<Order> findByVendorUsername(String username, Pageable pageable);

}
