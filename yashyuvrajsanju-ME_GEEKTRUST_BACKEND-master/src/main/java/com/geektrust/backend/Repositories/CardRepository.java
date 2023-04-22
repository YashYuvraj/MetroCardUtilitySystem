package com.geektrust.backend.Repositories;

import java.util.HashMap;
import java.util.Map;
import com.geektrust.backend.Entities.Card;

public class CardRepository implements ICardRepository{

private final Map<String,Card> cardMap;
    public CardRepository() {
        this.cardMap=new HashMap<>();
    }
    @Override
    public void save(Card card) {
        // TODO Auto-generated method stub
        cardMap.put(card.getCardNumber(),card);
    }

    public Card findByNumber(String cardNumber)
    {
        return cardMap.get(cardNumber);
    }
}
