package com.lyb.demo.mapper;

import com.lyb.demo.model.Order;

import java.util.List;

public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectAll();

    /**
     * 更新订单付款状态
     * lyb
     * @param id
     * @return
     */
    int updatePay(String id);

    //String findMaxId();

    int deleteOrderById(String id);

    /**
     * 更新订单已付款金额
     * @param id
     * @param monney
     * @return
     */
    int updateOrderMonney(Integer id,Integer monney);
}