package com.example.ajopay.dto.RequestDto;

public class Request {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmpassword;
    private String accountNumber;

    // Getter and setter for firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and setter for lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Getter and Setter for AccountNo
    public String getAccountNumber(){return accountNumber;}

    public void setAccountNumber(String accountNumber){this.accountNumber = accountNumber;}

    // Getter and setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and setter for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter and setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and setter for confirmpassword
    public String getConfirmpassword() {
        return confirmpassword;
    }


    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }



    public Request(String firstName, String lastName, String email, String phoneNumber, String password, String confirmpassword, String accountNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.accountNumber = accountNumber;
    }
}
