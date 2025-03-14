package com.example.ajopay.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class Savingplans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
    private String externalAccountNumber;
    private Double amount;
    private LocalDateTime startDate;
    private int durationInMonth;
    private  String savingTime;
    private boolean active= true;

    public Savingplans() {

    }

    private boolean isExpired(){
        return startDate.plusMonths(durationInMonth).isBefore(LocalDateTime.now());
    }

    public Savingplans(long id, Users user, String externalAccountNumber, Double amount, LocalDateTime startDate, int durationInMonth, String savingTime, boolean active) {
        this.id = id;
        this.user = user;
        this.externalAccountNumber = externalAccountNumber;
        this.amount = amount;
        this.startDate = startDate;
        this.durationInMonth = durationInMonth;
        this.savingTime = savingTime;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getSavingTime(String savingTime) {
        return this.savingTime;
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
        return "Savingplans{" +
                "id=" + id +
                ", user=" + user +
                ", externalAccountNumber='" + externalAccountNumber + '\'' +
                ", amount=" + amount +
                ", startDate=" + startDate +
                ", durationInMonth=" + durationInMonth +
                ", savingTime='" + savingTime + '\'' +
                ", active=" + active +
                '}';
    }
}
