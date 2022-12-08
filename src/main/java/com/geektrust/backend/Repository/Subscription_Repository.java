package com.geektrust.backend.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Subscription_Repository implements ISubscriptionRepository {

    private HashMap<Integer, LocalDate> subscriptionMap = new HashMap<>();  
    private static int user_Id = 1;

    public Subscription_Repository() {}
    public Subscription_Repository(HashMap<Integer, LocalDate> uSubscriptionMap) {
        this.subscriptionMap = uSubscriptionMap;
    }

    @Override
    public void save(LocalDate entity) {
        subscriptionMap.put(user_Id, entity);
        user_Id++;
    }

    @Override
    public LocalDate findById(Integer id) {
        return subscriptionMap.get(id);
    }

    @Override
    public void delete(LocalDate entity) {
        subscriptionMap.remove(entity);
    }

    @Override
    public void deleteById(Integer id) {
        LocalDate date = subscriptionMap.get(id);
        subscriptionMap.remove(date);
    }

    @Override
    public int count() {
        return this.subscriptionMap.size();
    }

    @Override
    public void setSubscriptionPrice(int userId, String category, String planType) {

    }
    
    @Override
    public List<LocalDate> findAll() {
        ArrayList<LocalDate> subscriptionStartDates = new ArrayList<LocalDate>();
        for(LocalDate startDates: subscriptionMap.values()) {
            subscriptionStartDates.add(startDates);
        }
        return subscriptionStartDates;
    }
    
}
