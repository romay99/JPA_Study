package com.jpa.demo.repository;

import com.jpa.demo.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class OrderSearch {
    private String memberName;
    private OrderStatus orderStatus;
}
