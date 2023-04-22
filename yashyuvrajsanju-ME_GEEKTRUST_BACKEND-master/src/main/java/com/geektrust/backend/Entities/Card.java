package com.geektrust.backend.Entities;


public class Card {
    private final String cardNumber;
    private int balance;
    private int times;
   
   
    public Card(String cardNumber, int balance,int times) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.times=times;
    }
    public int getBalance() {
        return balance;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public int getTimes() {
        return times;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void setTimes(int times) {
        this.times = times;
    }
}
