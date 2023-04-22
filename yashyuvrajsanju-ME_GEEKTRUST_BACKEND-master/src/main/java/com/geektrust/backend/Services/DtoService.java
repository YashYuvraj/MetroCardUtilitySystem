package com.geektrust.backend.Services;

import java.util.List;
import java.util.Map;
import com.geektrust.backend.Repositories.AirportRepository;
import com.geektrust.backend.Repositories.CentralRepository;

public class DtoService {

    private final AirportRepository airportRepository;
    private final CentralRepository centralRepository;

    public DtoService(AirportRepository airportRepository, CentralRepository centralRepository) {
        this.airportRepository = airportRepository;
        this.centralRepository = centralRepository;
    }
  
    public void print()
    {
        System.out.println("TOTAL_COLLECTION CENTRAL "+centralRepository.getTotalCost()+" "+centralRepository.getTotalDiscount());
        System.out.println("PASSENGER_TYPE_SUMMARY");
        List<Map.Entry<String, Integer>> centralList=centralRepository.getSortedOrder();
        for (Map.Entry<String, Integer> ent : centralList) 
        {
            System.out.println(ent.getKey()+" "+ent.getValue());
        }

        System.out.println("TOTAL_COLLECTION AIRPORT "+airportRepository.getTotalCost()+" "+airportRepository.getTotalDiscount());
        System.out.println("PASSENGER_TYPE_SUMMARY");
        List<Map.Entry<String, Integer>> airportList=airportRepository.getSortedOrder();
        for (Map.Entry<String, Integer> ent : airportList) 
        {
            System.out.println(ent.getKey()+" "+ent.getValue());
        }
    }

    
}
