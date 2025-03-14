package com.example.ajopay.service;

import com.example.ajopay.dto.RequestDto.SavingRequest;
import com.example.ajopay.model.Savingplans;

public interface SavingsPlanService {
    Savingplans createSavingsPlan(Long id, SavingRequest request);
}
