package com.geektrust.backend.Command;

import java.util.List;
import java.util.Map;
import com.geektrust.backend.Exception.DuplicateTopUpCommandException;
import com.geektrust.backend.Repository.ISubscriptionRepository;
import com.geektrust.backend.Repository.ISubscription_Category_Repository;

public class Add_TopUp_Command implements ICommand{

    private ISubscriptionRepository uISubscriptionRepository;
    private ISubscription_Category_Repository uISubscription_Category_Repository;
    private static int count = 1;


    public Add_TopUp_Command(ISubscriptionRepository iSubscriptionRepository, ISubscription_Category_Repository iSubscription_Category_Repository) {
        this.uISubscriptionRepository = iSubscriptionRepository;
        this.uISubscription_Category_Repository = iSubscription_Category_Repository;
    }

    @Override
    public void execute(List<String> tokens) {
        Integer userId = uISubscriptionRepository.count();
        Map<Integer, Integer> map = uISubscription_Category_Repository.getPriceMap();

        if(uISubscription_Category_Repository.count() == 0) {
            System.out.println("ADD_TOPUP_FAILED SUBSCRIPTION_NOT_FOUND");
        } else if(tokens.get(1).equals("FOUR_DEVICE")) {
            if(map.containsKey(userId) && count == userId) {
                count++;
                int sum = 50 * Integer.parseInt(tokens.get(2));
                if(map.containsKey(userId)) map.put(userId, map.get(userId) + sum);
            }
            else {
                count = 1;
                try{
                    throw new DuplicateTopUpCommandException();
                } catch (DuplicateTopUpCommandException e) {
                    System.out.println("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
                }
            }
        } else {
            int sum = 100 * Integer.parseInt(tokens.get(2));
            if(map.containsKey(userId)) map.put(userId, map.get(userId) + sum);
        }

        uISubscription_Category_Repository.setPriceMap(map);
    }
    
}
