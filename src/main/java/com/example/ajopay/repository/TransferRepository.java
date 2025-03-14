package com.example.ajopay.repository;

import com.example.ajopay.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository <Transaction,Long>{

}
