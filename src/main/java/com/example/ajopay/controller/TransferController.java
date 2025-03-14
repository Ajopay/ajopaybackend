package com.example.ajopay.controller;

import com.example.ajopay.dto.RequestDto.FundRequest;
import com.example.ajopay.dto.RequestDto.TransferRequest;
import com.example.ajopay.service.FundService;
import com.example.ajopay.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
//@CrossOrigin(origins = "*")
public class TransferController {
    @Autowired
    private TransferService transferService;
    @Autowired
    private FundService fundService;
    @PostMapping("/transfer")
    public ResponseEntity<Map<String, String>> transfer(@RequestBody TransferRequest transferRequest) {
        String response=transferService.transferMoney(transferRequest);
        return  ResponseEntity.ok(Collections.singletonMap("message", response));
    }
    @PostMapping("/fundwallet")
    public ResponseEntity<Map<String, String>> fundWallet(@RequestBody FundRequest fundRequest) {
        String response= fundService.fundwallet(fundRequest);
        return  ResponseEntity.ok(Collections.singletonMap("message", response));
    }
}
