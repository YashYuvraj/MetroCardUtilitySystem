package com.geektrust.backend.Repositories;

import com.geektrust.backend.Entities.Card;

public interface ICardRepository {
    public void save(Card card);

    public Card findByNumber(String cardNumber);
}
