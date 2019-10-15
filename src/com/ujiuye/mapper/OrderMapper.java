package com.ujiuye.mapper;

import com.ujiuye.pojo.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> getOrderByPid(int pid);
}
