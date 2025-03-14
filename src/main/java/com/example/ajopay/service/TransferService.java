package com.example.ajopay.service;

import com.example.ajopay.dto.RequestDto.TransferRequest;

public interface TransferService {
    String transferMoney(TransferRequest transferRequest);
}
