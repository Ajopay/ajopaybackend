package com.example.ajopay.repository;

import com.example.ajopay.model.FundWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundRepository extends JpaRepository <FundWallet,Long>{
}
