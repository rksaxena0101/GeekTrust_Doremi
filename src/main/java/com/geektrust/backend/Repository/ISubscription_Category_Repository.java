package com.geektrust.backend.Repository;

import java.util.List;
import java.util.Map;

public interface ISubscription_Category_Repository extends CRUD_Repository<String, Integer>{
    public void  addNoOfDaystoGivenDateAndPlanType(Integer userId, String planSubCategoryType);
    public void printCategory(String category);
    public Map<Integer, Integer> getPriceMap();
    public void setPriceMap(Map<Integer, Integer> priceMap);
    public Integer getPrice(Integer userId);
    public List<String> getDateList(Integer userId);
    public List<String> getCategories();
    public void makeListEmpty();
}
