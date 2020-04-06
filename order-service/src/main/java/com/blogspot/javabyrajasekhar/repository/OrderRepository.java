package com.blogspot.javabyrajasekhar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogspot.javabyrajasekhar.entity.Order;

public interface OrderRepository  extends JpaRepository<Order,Integer>{

}
