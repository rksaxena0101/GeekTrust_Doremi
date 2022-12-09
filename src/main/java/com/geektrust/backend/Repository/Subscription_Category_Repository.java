package com.geektrust.backend.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.geektrust.backend.Exception.DuplicateCategoryException;
import com.geektrust.backend.Factory.Exceptions.DateTimeNotExistException;


public class Subscription_Category_Repository implements ISubscription_Category_Repository {
    private Map<Integer, Integer> priceMap = new HashMap<Integer, Integer>();
    private HashMap<Integer, List<String>> dateMap = new HashMap<>();
    private HashMap<String, Integer> categoryRepository = new HashMap<>();
    private ISubscriptionRepository uISubscriptionRepository;
    private List<String> categoryMap = new ArrayList<>();
    
    public Subscription_Category_Repository(ISubscriptionRepository iSubscriptionRepository) {
        this.uISubscriptionRepository = iSubscriptionRepository;
    }

    //Return date in dd-MM-yyyy string format by adding number of days.
	 public void  addNoOfDaystoGivenDateAndPlanType(Integer userId, String planSubCategoryType) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dateParse = uISubscriptionRepository.findById(userId);
		Month month = dateParse.getMonth();
		boolean b = dateParse.isLeapYear();
        boolean subscriptionPlan = (planSubCategoryType.equals("FREE") || planSubCategoryType.equals("PERSONAL"));
	    int monthValue = month.length(b);
		
        String renewalDate = "";
        switch (monthValue) {
            case 28: 
				 renewalDate = (subscriptionPlan) ? 
                formatter.format(dateParse.plusDays(18)) : formatter.format(dateParse.plusDays(79));
                if(dateMap.containsKey(userId)) {
                    List<String> renewDate = dateMap.get(userId);
                    renewDate.add(renewalDate);
                    dateMap.put(userId, renewDate);
                } else {
                    List<String> renewDate = new ArrayList<String>();
                    renewDate.add(renewalDate);
                    dateMap.put(userId, renewDate);
                }
                break;
            case 29:
                renewalDate =(subscriptionPlan) ? 
                formatter.format(dateParse.plusDays(19)) : formatter.format(dateParse.plusDays(80));
                if(dateMap.containsKey(userId)) {
                    List<String> renewDate = dateMap.get(userId);
                    renewDate.add(renewalDate);
                    dateMap.put(userId, renewDate);
                } else {
                    List<String> renewDate = new ArrayList<String>();
                    renewDate.add(renewalDate);
                    dateMap.put(userId, renewDate);
                }
                break;
            case 30:
                renewalDate = (subscriptionPlan) ? 
                formatter.format(dateParse.plusDays(20)) : formatter.format(dateParse.plusDays(81));
                if(dateMap.containsKey(userId)) {
                    List<String> renewDate = dateMap.get(userId);
                    renewDate.add(renewalDate);
                    dateMap.put(userId, renewDate);
                } else {
                    List<String> renewDate = new ArrayList<String>();
                    renewDate.add(renewalDate);
                    dateMap.put(userId, renewDate);
                }
                break;
			case 31:
                renewalDate = (subscriptionPlan) ? 
                formatter.format(dateParse.plusDays(21)) : formatter.format(dateParse.plusDays(82));
                if(dateMap.containsKey(userId)) {
                    List<String> renewDate = dateMap.get(userId);
                    renewDate.add(renewalDate);
                    dateMap.put(userId, renewDate);
                } else {
                    List<String> renewDate = new ArrayList<String>();
                    renewDate.add(renewalDate);
                    dateMap.put(userId, renewDate);
                }
                break;
            default:
                throw new DateTimeNotExistException("INVALID DATE \n" + "ADD_SUBSCRIPTION_FAILED INVALID_DATE");
        }
	}

    @Override
    public void setSubscriptionPrice(int userId, String category, String planType) {
        int price = 0;
        List<Integer> priceList = new ArrayList<Integer>();

        if(priceMap.get(userId) == null) priceMap.put(userId, 0);

        switch(category) {
            case "MUSIC":
                price = (planType.equals("PERSONAL")) ? 100 : planType.equals("PREMIUM") ? 250 : 0;
                priceMap.put(userId, priceMap.get(userId)+price);
                break;
            case "VIDEO":
                price = (planType.equals("PERSONAL")) ? 200 : planType.equals("PREMIUM") ? 500 : 0;
                priceMap.put(userId, priceMap.get(userId)+price);
                break;
            case "PODCAST": 
                price = (planType.equals("PERSONAL")) ? 100 : planType.equals("PREMIUM") ? 300 : 0;
                priceMap.put(userId, priceMap.get(userId)+price);
                break;
            default:
                price = 0;
        }
        
        for(Integer prices: priceMap.values()) priceList.add(prices);
    }

    @Override
    public void save(String category) {
        if(categoryRepository.containsKey(category)) throw new DuplicateCategoryException("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
        else {
            categoryRepository.put(category, uISubscriptionRepository.count());
        }
    }

    public void printCategory(String category) {
        categoryMap.add(category);
    }

    @Override
    public String findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(String entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int count() {
        return categoryRepository.size();
    }

    @Override
    public List<LocalDate> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<Integer, Integer> getPriceMap() {
        return this.priceMap;
    }

    @Override
    public void setPriceMap(Map<Integer, Integer> priceMap) {
        this.priceMap = priceMap;
    }

    @Override
    public Integer getPrice(Integer userId) {
        return priceMap.get((userId));
    }

    @Override
    public List<String> getDateList(Integer userId) {
        return dateMap.get(userId);
    }

    @Override
    public List<String> getCategories() {
        return categoryMap;
    }

    @Override
    public void makeListEmpty() {
        categoryMap.clear();    
    }
    
}
