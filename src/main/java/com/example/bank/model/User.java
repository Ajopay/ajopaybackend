package com.example.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String surname;
    private String emailAddress;
    private String phoneNumber;
    private String referralCode;
    private String supportCode;
    private String password;
    private String confirmPassword;

    // No-argument constructor
    public User() {}

    // All-argument constructor
    public User(Long id, String firstName, String surname, String emailAddress, String phoneNumber,
                String referralCode, String supportCode, String password, String confirmPassword) {
        this.id = id;
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
    public Long getId() {
        return id;
    }

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
    public void setId(Long id) {
        this.id = id;
    }

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
