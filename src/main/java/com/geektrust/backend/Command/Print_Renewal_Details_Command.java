package com.geektrust.backend.Command;

import java.util.List;
import com.geektrust.backend.Repository.ISubscriptionRepository;
import com.geektrust.backend.Repository.ISubscription_Category_Repository;

public class Print_Renewal_Details_Command implements ICommand{

    private ISubscription_Category_Repository uISubscription_Category_Repository;
    private ISubscriptionRepository uISubscriptionRepository;

    public Print_Renewal_Details_Command(ISubscription_Category_Repository iSubscription_Category_Repository, ISubscriptionRepository iSubscriptionRepository) {
        this.uISubscription_Category_Repository = iSubscription_Category_Repository;
        this.uISubscriptionRepository = iSubscriptionRepository;
    }

    @Override
    public void execute(List<String> tokens) {
        Integer userId = uISubscriptionRepository.count();

        if(uISubscription_Category_Repository.count() == 0) {

            System.out.println("SUBSCRIPTIONS_NOT_FOUND");

         } else {      
            Integer price = uISubscription_Category_Repository.getPrice(userId);
            List<String> dateList = uISubscription_Category_Repository.getDateList(userId);
            List<String> categoryList = uISubscription_Category_Repository.getCategories();

            for(int i=0; i<dateList.size(); i++) System.out.println("RENEWAL_REMINDER "+ categoryList.get(i) + " " + dateList.get(i));

            uISubscription_Category_Repository.makeListEmpty();

            System.out.println("RENEWAL_AMOUNT " + price);
            
         }
    }
    
}
