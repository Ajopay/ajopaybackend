package com.example.ajopay.service.Implement;

import com.example.ajopay.dto.RequestDto.EmailDetails;
import com.example.ajopay.dto.RequestDto.TransferRequest;
import com.example.ajopay.enums.TransactionStatus;
import com.example.ajopay.model.Transaction;
import com.example.ajopay.model.Users;
import com.example.ajopay.repository.TransferRepository;
import com.example.ajopay.repository.UserRepository;
import com.example.ajopay.service.EmailService;
import com.example.ajopay.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TransferServiceImplement implements TransferService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransferRepository transferRepository;
    @Autowired
private EmailService emailService;
    @Transactional
    public String transferMoney(TransferRequest transferRequest) {
        Users sender =userRepository.findByAccountNumber(transferRequest.getSenderAccount()).orElseThrow(()->
                new RuntimeException("Sender account not found"));
        Users receiver= userRepository.findByAccountNumber(transferRequest.getReceiverAccount()).orElseThrow(()->
                new RuntimeException("Receiver account not found"));


        if(sender.getAvailableBalance() < transferRequest.getAmount()){
            throw  new RuntimeException("Insufficient balance");
        }
        sender.setAvailableBalance(sender.getAvailableBalance() - transferRequest.getAmount());
        receiver.setAvailableBalance(receiver.getAvailableBalance() + transferRequest.getAmount());

        userRepository.save(sender);
        userRepository.save(receiver);
        EmailDetails emailDetails= new EmailDetails();
        emailDetails.setRecipient(sender.getEmail());
        emailDetails.setSubject("Transfer Successful");
        emailDetails.setMesageBody("Dear" +  " " +sender.getLastName() + " " +sender.getFirstName() +
                "\n\n" + "Your transfer of " + transferRequest.getAmount() + " is successful." +" "+ "Your available balance is " +
                sender.getAvailableBalance() + " " +
                "Thank you for using our service");

emailService.sendEmailAlert(emailDetails);


        Transaction transaction = new Transaction();
        transaction.setAmount(transferRequest.getAmount());
        transaction.setSenderAccount(transferRequest.getSenderAccount());
        transaction.setReceiverAccount(transferRequest.getReceiverAccount());
        transaction.getTimestamp(LocalDateTime.now());
        transaction.setStatus(TransactionStatus.SUCCESS);

        transferRepository.save(transaction);
        return "Transfer successful";
    }
}
