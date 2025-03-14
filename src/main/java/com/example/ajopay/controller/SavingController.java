package com.example.ajopay.controller;

import com.example.ajopay.dto.RequestDto.SavingRequest;
import com.example.ajopay.model.Savingplans;
import com.example.ajopay.service.SavingsPlanService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "*")
@RestController
public class SavingController {
    @Autowired

    private SavingsPlanService savingsPlanService;
    @PostMapping("/create/{userId}")
    public ResponseEntity<String> createSavingsPlan(@PathVariable Long userId, @RequestBody SavingRequest savingRequest) {
    savingsPlanService.createSavingsPlan(userId, savingRequest);
    return ResponseEntity.ok("Saving plan created successfully");
    }
    //public ResponseEntity<List<Savingplans>> getActiveSavingsPlans() {
      //  return  ResponseEntity.ok(savingsPlanService.getActiveSavingsPlans());

    //}
}
