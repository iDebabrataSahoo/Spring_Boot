package com.sanku.saga.choreography.paymentservice.repository;


import com.sanku.saga.choreography.paymentservice.entity.UserBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBalanceRepository extends JpaRepository<UserBalance,Integer> {
}
