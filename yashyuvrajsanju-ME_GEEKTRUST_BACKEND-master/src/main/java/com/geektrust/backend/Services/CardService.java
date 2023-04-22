package com.geektrust.backend.Services;

import com.geektrust.backend.Entities.Card;
import com.geektrust.backend.Repositories.AirportRepository;
import com.geektrust.backend.Repositories.CentralRepository;
import com.geektrust.backend.Repositories.ICardRepository;

public class CardService implements ICardService{
   
    private final ICardRepository cardRepository;
    private final AirportRepository airportRepository;
   private final CentralRepository centralRepository;

   public CardService(ICardRepository cardRepository, AirportRepository airportRepository,
            CentralRepository centralRepository) {
        this.cardRepository = cardRepository;
        this.airportRepository = airportRepository;
        this.centralRepository = centralRepository;
    }



   

    @Override
    public Card create(String cardNumber, int balance) {
        // TODO Auto-generated method stub
         Card card=new Card(cardNumber, balance,0);
         cardRepository.save(card);
        return card;
    }
     
    @Override
    public int calculateFare(String cardNumber,String typ,String origin)
    {
        Card card=cardRepository.findByNumber(cardNumber); 
        int balance=card.getBalance();
        int cost[]=price(typ,card);
        double fare=0;
        if(cost[1]<=balance)
        {
        fare=cost[1];
        balance=balance-cost[1];
        }
        else
        {
            fare=(cost[1]-card.getBalance())*0.02+cost[1];
            balance=0;

        }
        card.setTimes(card.getTimes()+1);
        card.setBalance(balance);
       // cardRepository.save(card);
        locationService(origin,typ,(int)fare,cost[2]);
        return (int)fare;
    }

    @Override
    public int[] price(String typ,Card card)
    {
        int arr[]=new int[3];
        int cost=0;
        if(typ.equals("SENIOR_CITIZEN"))
        cost=100;
        else
        if(typ.equals("ADULT"))
        cost=200;
        else 
        cost=50;
        arr[0]=cost;
        if(card.getTimes()%2!=0)
        {
        cost=cost/2;
        arr[2]=cost;
        }
        arr[1]=cost;
        return arr;
    }

    public void locationService(String origin,String typ,int fare,int disc)
    {
        if(origin.equals("AIRPORT"))
        {
            airportRepository.saveCost(fare);
            airportRepository.savePassenger(typ);
            airportRepository.saveDiscount(disc);
        }
        else
        {
            centralRepository.saveCost(fare);
            centralRepository.savePassenger(typ);
            centralRepository.saveDiscount(disc);
        }
    }
    
}
