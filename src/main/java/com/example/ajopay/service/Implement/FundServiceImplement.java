package com.example.ajopay.service.Implement;

import com.example.ajopay.dto.RequestDto.EmailDetails;
import com.example.ajopay.dto.RequestDto.FundRequest;
import com.example.ajopay.enums.TransactionStatus;
import com.example.ajopay.model.FundWallet;
import com.example.ajopay.model.Users;
import com.example.ajopay.repository.FundRepository;
import com.example.ajopay.repository.UserRepository;
import com.example.ajopay.service.EmailService;
import com.example.ajopay.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundServiceImplement implements FundService {
    @Autowired
     private FundRepository fundRepository;
    @Autowired
     private UserRepository userRepository;
    @Autowired
private EmailService emailService;



    public String fundwallet(FundRequest fundRequest) {
        Users sender= userRepository.findByAccountNumber(fundRequest.getSenderAccount()).orElseThrow(()->
                new RuntimeException("Sender account not found"));
        Users receiver=userRepository.findByAccountNumber(fundRequest.getReceiverAccount()).orElseThrow(()->
                new RuntimeException("Receiver account not found"));

        if(sender.getAvailableBalance() < fundRequest.getAmount()){
            throw  new RuntimeException("Insufficient balance");
        }
        sender.setTotalBalance(sender.getTotalBalance() - fundRequest.getAmount());
        receiver.setTotalBalance(receiver.getTotalBalance() + fundRequest.getAmount());
        userRepository.save(sender);
        userRepository.save(receiver);
        EmailDetails emailDetails= new EmailDetails();
        emailDetails.setRecipient(sender.getEmail());
        emailDetails.setSubject("Request  to Fund AjoPay");
        emailDetails.setMesageBody("Your Account "+ sender.getAccountNumber() + "request for" + fundRequest.getAmount() + "." +
                "This is your otp ****," + "AjoPay will never ak for your OTP. Please do not share it");


        emailService.sendEmailAlert(emailDetails);


        FundWallet fundWallet=new FundWallet();
        fundWallet.setAmount(fundRequest.getAmount());
        fundWallet.setSenderAccount(sender.getAccountNumber());
        fundWallet.setReceiverAccount(receiver.getAccountNumber());
        fundWallet.setSenderBank(fundRequest.getSenderBank());
        fundWallet.setStatus(TransactionStatus.SUCCESS);

        fundRepository.save(fundWallet);
        return "Account funded succesfully";
    }
}
