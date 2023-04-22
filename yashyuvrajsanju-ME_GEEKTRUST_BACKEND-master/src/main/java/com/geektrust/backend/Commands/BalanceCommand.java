package com.geektrust.backend.Commands;

import java.util.List;
import com.geektrust.backend.Services.ICardService;

public class BalanceCommand implements ICommand {
    private ICardService cardService;

    public BalanceCommand(ICardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        cardService.create(tokens.get(1), Integer.parseInt(tokens.get(2)));
        
    }
    
}
