package com.example.ajopay.dto.Reponse;

import lombok.*;


public class Response {
    private String message;
    private String firstName;
    private String accountNumber;


    public Response() {
    }

    public Response(String message, String firstName, String accountNumber) {
        this.message = message;
        this.firstName = firstName;
        this.accountNumber = accountNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", firstName='" + firstName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}

