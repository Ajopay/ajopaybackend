package com.example.ajopay.model;

import com.example.ajopay.enums.TransactionStatus;
import jakarta.persistence.*;
@Entity
public class FundWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Fundid;
    private String senderAccount;
    private String senderBank;
    private String receiverAccount;
    private double amount;
    private String otp;
    private String pin;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    public FundWallet(long fundid, String senderAccount, String senderBank, String receiverAccount, double amount, String otp, String pin, TransactionStatus status) {
        Fundid = fundid;
        this.senderAccount = senderAccount;
        this.senderBank = senderBank;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
        this.otp = otp;
        this.pin = pin;
        this.status = status;
    }

    public FundWallet() {

    }

    public long getFundid() {
        return Fundid;
    }

    public void setFundid(long fundid) {
        Fundid = fundid;
    }

    public String getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public String getSenderBank() {
        return senderBank;
    }

    public void setSenderBank(String senderBank) {
        this.senderBank = senderBank;
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

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FundWallet{" +
                "Fundid=" + Fundid +
                ", senderAccount='" + senderAccount + '\'' +
                ", senderBank='" + senderBank + '\'' +
                ", receiverAccount='" + receiverAccount + '\'' +
                ", amount=" + amount +
                ", otp='" + otp + '\'' +
                ", pin='" + pin + '\'' +
                ", status=" + status +
                '}';
    }
}
