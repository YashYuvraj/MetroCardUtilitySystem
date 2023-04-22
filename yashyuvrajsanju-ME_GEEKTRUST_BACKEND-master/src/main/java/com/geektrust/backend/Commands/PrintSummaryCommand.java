package com.geektrust.backend.Commands;

import java.util.List;
import com.geektrust.backend.Services.DtoService;

public class PrintSummaryCommand implements ICommand{
    
 DtoService dtoService;
    
    public PrintSummaryCommand(DtoService dtoService) {
    this.dtoService = dtoService;
}

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        dtoService.print();

        
    }
    
}
