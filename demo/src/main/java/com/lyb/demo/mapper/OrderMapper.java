package com.lyb.demo.mapper;

import com.lyb.demo.model.Order;

import java.util.List;

public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectAll();

    int updatePay(String id);

    String findMaxId();

    int deleteOrderById(String id);
}