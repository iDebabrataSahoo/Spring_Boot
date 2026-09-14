package com.sanku.saga.choreography.orderservice.controller;

import com.sanku.saga.choreography.common.dto.OrderRequestDto;
import com.sanku.saga.choreography.orderservice.entity.PurchaseOrder;
import com.sanku.saga.choreography.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @GetMapping
    public List<PurchaseOrder> findAllProduct() {
        return orderService.findAll();
    }
    @PostMapping("/create")
    public PurchaseOrder createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        return orderService.createOrder(orderRequestDto);
    }
}
