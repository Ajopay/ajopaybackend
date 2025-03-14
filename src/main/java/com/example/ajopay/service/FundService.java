package com.example.ajopay.service;

import com.example.ajopay.dto.RequestDto.FundRequest;

public interface FundService {
    String fundwallet(FundRequest fundRequest);
}
