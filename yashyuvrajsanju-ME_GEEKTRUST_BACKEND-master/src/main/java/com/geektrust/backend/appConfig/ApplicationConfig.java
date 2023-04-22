package com.geektrust.backend.appConfig;

import com.geektrust.backend.Commands.BalanceCommand;
import com.geektrust.backend.Commands.CheckInCommand;
import com.geektrust.backend.Commands.CommandInvoker;
import com.geektrust.backend.Commands.PrintSummaryCommand;
import com.geektrust.backend.Repositories.AirportRepository;
import com.geektrust.backend.Repositories.CardRepository;
import com.geektrust.backend.Repositories.CentralRepository;
import com.geektrust.backend.Repositories.ICardRepository;
import com.geektrust.backend.Services.CardService;
import com.geektrust.backend.Services.DtoService;
import com.geektrust.backend.Services.ICardService;

public class ApplicationConfig {
    private final ICardRepository cardRepository=new CardRepository();
    private final AirportRepository airportRepository=new AirportRepository();
    private final CentralRepository centralRepository=new CentralRepository();
    private final ICardService cardService=new CardService(cardRepository, airportRepository, centralRepository);
    private final DtoService dtoService=new DtoService(airportRepository, centralRepository);
    private final CheckInCommand checkInCommand=new CheckInCommand(cardService);
    private final BalanceCommand balanceCommand=new BalanceCommand(cardService);
    private final PrintSummaryCommand printSummaryCommand=new PrintSummaryCommand(dtoService);

    private final CommandInvoker commandInvoker=new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("BALANCE",balanceCommand);
        commandInvoker.register("CHECK_IN",checkInCommand);
        commandInvoker.register("PRINT_SUMMARY",printSummaryCommand);
  
        return commandInvoker;
    }
}
