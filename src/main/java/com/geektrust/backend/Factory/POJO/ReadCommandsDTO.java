package com.geektrust.backend.Factory.POJO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReadCommandsDTO {

    private String subscriptionStartDate;
    private String commandNames;
    private String categoryTypes;
    private String planTypes;
    private String numberOfTopUpDevices;
    private int topUpMonth;
    private Integer user_Id = 0;

    public ReadCommandsDTO() {
    }
   
    //Reference https://www.geeksforgeeks.org/create-hashmap-with-multiple-values-associated-with-the-same-key-in-java/
    /*
    {0 = [[START_SUBSCRIPTION 20-02-2022], [ADD_SUBSCRIPTION MUSIC PERSONAL], [ADD_SUBSCRIPTION VIDEO PREMIUM],
        [ADD_SUBSCRIPTION PODCAST FREE],[ADD_TOPUP FOUR_DEVICE 3], PRINT_RENEWAL_DETAILS],
     1 = [[START_SUBSCRIPTION 23-01-2022],[ADD_SUBSCRIPTION MUSIC PERSONAL],[ADD_TOPUP FOUR_DEVICE 2],[PRINT_RENEWAL_DETAILS]    
    }
    */ 
    public ReadCommandsDTO(List<List<String>> readCommandAndValues) {
        Map<Boolean, List<List<String>>> map = readCommandAndValues.stream().collect(Collectors.partitioningBy(s -> s.equals("START_SUBSCRIPTION")));
        HashMap<Integer, List<List<String>>> hm = new HashMap<Integer, List<List<String>>>();
        System.out.println(map);
        for(int i = 0; i < readCommandAndValues.size(); i++) {
            System.out.println(readCommandAndValues.get(i));
            if(readCommandAndValues.get(i).get(0).equals("START_SUBSCRIPTION")) {
                hm.put(user_Id++, readCommandAndValues);
                
            } 
        }
        // System.out.println(hm);
    }
    
    public ReadCommandsDTO(String commandNames, String subscriptionStartDate, String categoryTypes,
            String planTypes, String numberOfTopUpDevices, int topUpMonth) {
        this.subscriptionStartDate = subscriptionStartDate;
        this.commandNames = commandNames;
        this.categoryTypes = categoryTypes;
        this.planTypes = planTypes;
        this.numberOfTopUpDevices = numberOfTopUpDevices;
        this.topUpMonth = topUpMonth;
    }

    public ReadCommandsDTO(String commandNames) {
        this.commandNames = commandNames;
    }

    public String getSubscriptionStartDate() {
        return subscriptionStartDate;
    }
    public void setSubscriptionStartDate(String subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }
    public String getCommandNames() {
        return commandNames;
    }
    public void setCommandNames(String commandNames) {
        this.commandNames = commandNames;
    }
    public String getCategoryTypes() {
        return categoryTypes;
    }
    public void setCategoryTypes(String categoryTypes) {
        this.categoryTypes = categoryTypes;
    }
    public String getPlanTypes() {
        return planTypes;
    }
    public void setPlanTypes(String planTypes) {
        this.planTypes = planTypes;
    }
    public String getNumberOfTopUpDevices() {
        return numberOfTopUpDevices;
    }
    public void setNumberOfTopUpDevices(String numberOfTopUpDevices) {
        this.numberOfTopUpDevices = numberOfTopUpDevices;
    }
    public int getTopUpMonth() {
        return topUpMonth;
    }
    public void setTopUpMonth(int topUpMonth) {
        this.topUpMonth = topUpMonth;
    }

    

}
