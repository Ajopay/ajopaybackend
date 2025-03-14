package com.example.ajopay.service.Implement;

import com.example.ajopay.dto.RequestDto.SavingRequest;
import com.example.ajopay.model.Savingplans;
import com.example.ajopay.model.Users;
import com.example.ajopay.repository.SavingsPlanRepository;
import com.example.ajopay.repository.UserRepository;
import com.example.ajopay.service.SavingsPlanService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingsPlanServiceImplement implements SavingsPlanService {
    @Autowired
private SavingsPlanRepository savingsPlanRepository;
    @Autowired
private UserRepository userRepository;
    @Transactional

    @Override
    public Savingplans createSavingsPlan(Long id, SavingRequest request) {
        Optional<Users> userOpt=userRepository.findById(id);
        if(userOpt.isEmpty()) {
        throw new RuntimeException("User not found");
        }
        Users user=userOpt.get();
        if(!user.getExternalAccount().contains(request.getExternalAccountNumber())){
            throw new RuntimeException("Invalid external account");
        }
        Savingplans savingsplan=new Savingplans();
        savingsplan.setUser(user);
        savingsplan.setAmount(request.getAmount());
        savingsplan.setExternalAccountNumber(request.getExternalAccountNumber());
        savingsplan.setDurationInMonth(request.getDurationInMonth());
        savingsplan.getSavingTime(request.getSavingTime());

        return savingsPlanRepository.save(savingsplan);
    }
    public List<Savingplans> getActiveSavingsPlans(){
        return savingsPlanRepository.findByActiveTrue();
    }
}
