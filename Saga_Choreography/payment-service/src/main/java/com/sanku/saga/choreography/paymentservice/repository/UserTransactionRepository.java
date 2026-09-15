package com.sanku.saga.choreography.paymentservice.repository;

import com.sanku.saga.choreography.paymentservice.entity.UserTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTransactionRepository extends JpaRepository<UserTransaction,Integer> {
}
