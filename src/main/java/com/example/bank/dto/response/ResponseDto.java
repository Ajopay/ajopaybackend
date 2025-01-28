package com.example.bank.dto.response;

public class ResponseDto {
    private String firstName;  // example field, adjust to your case

    // No-argument constructor
    public ResponseDto() {
    }

    // Constructor that accepts a String
    public ResponseDto(String firstName) {
        this.firstName = firstName;
    }

    // Getter and setter for firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}