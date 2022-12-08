package com.geektrust.backend.Entity;

import com.geektrust.backend.Factory.Interfaces.SubscriptionCategory;
import com.geektrust.backend.Factory.Interfaces.SubscriptionPlanType;

public class Music implements SubscriptionCategory, SubscriptionPlanType{
    
    private int price;
    private String date;
    private String categoryType = "music";

    @Override
    public String getCategory() {
        return this.categoryType;
    }

    @Override
    public void addSubscription(String subscriptionCategory, String planName) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getFreePlan() {
        return null;
    }

    @Override
    public String getPersonalPlan() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPremiumPlan() {
        // TODO Auto-generated method stub
        return null;
    }

    
}
