package com.example.ajopay.dto.RequestDto;

import com.example.ajopay.model.Users;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class SavingRequest {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
    private String externalAccountNumber;
    private Double amount;
    private LocalDateTime startDate;
    private int durationInMonth;
    private  String savingTime;
    private boolean active= true;

    public SavingRequest(Users user, String externalAccountNumber, Double amount, LocalDateTime startDate, int durationInMonth, String savingTime, boolean active) {
        this.user = user;
        this.externalAccountNumber = externalAccountNumber;
        this.amount = amount;
        this.startDate = startDate;
        this.durationInMonth = durationInMonth;
        this.savingTime = savingTime;
        this.active = active;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getExternalAccountNumber() {
        return externalAccountNumber;
    }

    public void setExternalAccountNumber(String externalAccountNumber) {
        this.externalAccountNumber = externalAccountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public int getDurationInMonth() {
        return durationInMonth;
    }

    public void setDurationInMonth(int durationInMonth) {
        this.durationInMonth = durationInMonth;
    }

    public String getSavingTime() {
        return savingTime;
    }

    public void setSavingTime(String savingTime) {
        this.savingTime = savingTime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "SavingRequest{" +
                "user=" + user +
                ", externalAccountNumber='" + externalAccountNumber + '\'' +
                ", amount=" + amount +
                ", startDate=" + startDate +
                ", durationInMonth=" + durationInMonth +
                ", savingTime='" + savingTime + '\'' +
                ", active=" + active +
                '}';
    }
}
