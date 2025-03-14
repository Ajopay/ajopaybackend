package com.example.ajopay.dto.RequestDto;

import java.time.LocalDate;

public class TransferRequest {
    private String senderAccount;
    private String receiverAccount;
    private  double amount;
    private String pin;
    private String note;

    public TransferRequest(String senderAccount, String receiverAccount, double amount, String pin, String note) {
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
        this.pin = pin;
        this.note = note;
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

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "TransferRequest{" +
                "senderAccount='" + senderAccount + '\'' +
                ", receiverAccount='" + receiverAccount + '\'' +
                ", amount=" + amount +
                ", pin='" + pin + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
