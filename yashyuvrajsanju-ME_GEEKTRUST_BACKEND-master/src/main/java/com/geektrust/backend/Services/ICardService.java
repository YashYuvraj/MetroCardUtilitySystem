package com.geektrust.backend.Services;

import com.geektrust.backend.Entities.Card;

public interface ICardService {
    public Card create(String cardNumber,int balance);
    public int calculateFare(String cardNumber,String typ,String origin);
    public int[] price(String typ,Card card);
}
