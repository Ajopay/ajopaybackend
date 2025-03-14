package com.example.ajopay.service;

import com.example.ajopay.dto.RequestDto.EmailDetails;

public interface EmailService {
    void sendEmailAlert(EmailDetails emailDetails);
}
