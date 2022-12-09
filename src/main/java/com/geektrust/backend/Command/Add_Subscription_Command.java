package com.geektrust.backend.Command;

import java.util.List;
import com.geektrust.backend.Exception.DuplicateCategoryException;
import com.geektrust.backend.Repository.ISubscriptionRepository;
//import com.geektrust.backend.Repository.ISubscriptionRepository;
import com.geektrust.backend.Repository.ISubscription_Category_Repository;

public class Add_Subscription_Command implements ICommand{

    private ISubscription_Category_Repository iSubscription_Category_Repository;
    private ISubscriptionRepository iSubscriptionRepository;

    public Add_Subscription_Command(ISubscription_Category_Repository uISubscription_Category_Repository, ISubscriptionRepository uIsubscriptionRepository) {
        this.iSubscription_Category_Repository = uISubscription_Category_Repository;
        this.iSubscriptionRepository = uIsubscriptionRepository;
    }
    
    @Override
    public void execute(List<String> tokens) {
        if(iSubscriptionRepository.count() == 0) {
            System.out.println("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
        } else {
            try {
                String category = tokens.get(1);
                String planType = tokens.get(2);
                Integer userId = iSubscriptionRepository.count();
                iSubscription_Category_Repository.save(category);
                iSubscription_Category_Repository.printCategory(category);
                iSubscription_Category_Repository.setSubscriptionPrice(userId, category, planType);
                iSubscription_Category_Repository.addNoOfDaystoGivenDateAndPlanType(userId, planType);
            } catch(DuplicateCategoryException ex) {
                System.out.println("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
            }
        }
    }
    
}
