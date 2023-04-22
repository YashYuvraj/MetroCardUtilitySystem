package com.geektrust.backend.Commands;

import java.util.List;
import com.geektrust.backend.Services.ICardService;

public class CheckInCommand implements ICommand {
    
    ICardService cardService;

    public CheckInCommand(ICardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        cardService.calculateFare(tokens.get(1), tokens.get(2),tokens.get(3));
        
    }


    
}
