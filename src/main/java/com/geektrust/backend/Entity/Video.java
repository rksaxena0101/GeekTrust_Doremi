package com.geektrust.backend.Entity;

import com.geektrust.backend.Factory.Interfaces.SubscriptionCategory;
import com.geektrust.backend.Factory.Interfaces.SubscriptionPlanType;

public class Video implements SubscriptionCategory, SubscriptionPlanType{

    private String categoryType = "video";

    @Override
    public String getCategory() {
        return this.categoryType;
    }

    @Override
    public void addSubscription(String subscriptionCategory, String planName) {
        
    }

    @Override
    public String getFreePlan() {
        // TODO Auto-generated method stub
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
