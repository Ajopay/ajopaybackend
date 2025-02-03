package com.example.bank.dto.response;

public class ResponseDto {
    private String firstName; // example field, adjust to your case
    private String accountNumber;

    public ResponseDto(String firstName) {
        this.firstName = firstName;
        this.accountNumber = accountNumber;
    }
// No-argument constructor

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
}