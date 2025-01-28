package com.example.bank.dto.request;

public class RequestDto {
    private String firstName;
    private String surname;
    private String emailAddress;
    private String phoneNumber;
    private String referralCode;
    private String supportCode;
    private String password;
    private String confirmPassword;

    // No-argument constructor
    public RequestDto() {}

    // All-argument constructor
    public RequestDto(String firstName, String surname, String emailAddress, String phoneNumber,
                      String referralCode, String supportCode, String password, String confirmPassword) {
        this.firstName = firstName;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.referralCode = referralCode;
        this.supportCode = supportCode;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public String getSupportCode() {
        return supportCode;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public void setSupportCode(String supportCode) {
        this.supportCode = supportCode;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
