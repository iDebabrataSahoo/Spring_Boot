package com.sanku.saga.choreography.orderservice.service;

import com.sanku.saga.choreography.common.dto.OrderRequestDto;
import com.sanku.saga.choreography.common.event.OrderStatus;
import com.sanku.saga.choreography.orderservice.config.OrderStatusPublisher;
import com.sanku.saga.choreography.orderservice.entity.PurchaseOrder;
import com.sanku.saga.choreography.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    OrderStatusPublisher orderStatusPublisher;

    public List<PurchaseOrder> findAll() {
        return orderRepository.findAll();
    }
    @Transactional
    public PurchaseOrder createOrder(OrderRequestDto orderRequestDto) {
        PurchaseOrder saveOrder = orderRepository.save(dtoToEntity(orderRequestDto));
        orderRequestDto.setOrderId(saveOrder.getId());
        //produce kafka event with status ORDER_CREATED
        orderStatusPublisher.publishOrderEvent(orderRequestDto, OrderStatus.ORDER_CREATED);
        return saveOrder;
    }

    private PurchaseOrder dtoToEntity(OrderRequestDto orderRequestDto) {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setProductId(orderRequestDto.getProductId());
        purchaseOrder.setUserId(orderRequestDto.getUserId());
        purchaseOrder.setOrderStatus(OrderStatus.ORDER_CREATED);
        purchaseOrder.setPrice(orderRequestDto.getAmount());
        return purchaseOrder;
    }
}
