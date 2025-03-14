package com.example.ajopay.dto.RequestDto;

public class FundRequest {
    private  String senderBank;
    private String senderAccount;

    private String receiverAccount;
    private double amount;
    private String otp;
    private String pin;

    public FundRequest(String senderAccount, String senderBank, String receiverAccount, double amount, String otp, String pin) {
        this.senderAccount = senderAccount;
        this.senderBank = senderBank;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
        this.otp = otp;
        this.pin = pin;
    }

    public String getSenderBank() {
        return senderBank;
    }

    public void setSenderBank(String senderBank) {
        this.senderBank = senderBank;
    }

    public String getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "FundRequest{" +
                "senderBank='" + senderBank + '\'' +
                ", senderAccount='" + senderAccount + '\'' +
                ", receiverAccount='" + receiverAccount + '\'' +
                ", amount=" + amount +
                ", otp='" + otp + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}
