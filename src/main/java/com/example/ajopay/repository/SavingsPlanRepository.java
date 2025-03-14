package com.example.ajopay.repository;

import com.example.ajopay.model.Savingplans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavingsPlanRepository extends JpaRepository <Savingplans,Long>{
    List<Savingplans> findByActiveTrue();
}
