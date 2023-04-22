package com.geektrust.backend.Repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CentralRepository {
    private final List<Integer> collection;  
    private final Map<String,Integer> map;
    private final List<Integer> discount;

    public CentralRepository() {
        this.collection = new ArrayList<>();
        this.map = new HashMap<>();
        this.discount=new ArrayList<>();
    }

    public void saveDiscount(int disc)
    {
        discount.add(disc);
    }

    public void saveCost(int cost)
    {
        collection.add(cost);
    }
    public void savePassenger(String type)
    {
        map.put(type,map.getOrDefault(type, 0)+1);
    }

    public long getTotalCost()
    {
        long sum=0;
        for(int n:collection)
        {
            sum+=n;
        }
        return sum;
    }

    public long getTotalDiscount()
    {
        long sum=0;
        for(int n:discount)
        {
            sum+=n;
        }
        return sum;
    }

    public List<Map.Entry<String, Integer>> getSortedOrder()
    {
        List<Map.Entry<String, Integer> > list =
               new LinkedList<Map.Entry<String, Integer> >(map.entrySet());
               Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
                public int compare(Map.Entry<String, Integer> o1,
                                   Map.Entry<String, Integer> o2)
                {
                    if(o1.getValue()!=o2.getValue())
                    return (o2.getValue()).compareTo(o1.getValue());
                    else
                    return(o1.getKey().compareTo(o2.getKey()));
                }
            });
      return list;
    }

}
