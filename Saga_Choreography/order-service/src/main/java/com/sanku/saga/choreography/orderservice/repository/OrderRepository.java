package com.sanku.saga.choreography.orderservice.repository;

import com.sanku.saga.choreography.orderservice.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<PurchaseOrder,Integer> {
}
