package com.geektrust.backend.Factory;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import com.geektrust.backend.Entity.Music;
import com.geektrust.backend.Entity.Poadcast;
import com.geektrust.backend.Entity.Video;
import com.geektrust.backend.Factory.Exceptions.DateTimeNotExistException;
import com.geektrust.backend.Factory.Interfaces.SubscriptionCategory;

public class SubscriptionFactory {
    private String sCategoryType;
//    private ReadCommandsDTO readComm;

    public SubscriptionFactory(String categoryType) {
        this.sCategoryType = categoryType;
    }

    public SubscriptionCategory getCategoryType(String categoryType) {
        if(categoryType == null) return null;
        //System.out.println(readComm.getCommandNames());
        
        switch (categoryType) {
            case "video": 
                return new Video();
            case "podcast":
                return new Poadcast();
            case "music":
                return new Music();
            default:
                throw new IllegalArgumentException("Unknown Category"+categoryType);
        }
    }

    //Return date in dd-MM-yyyy string format by adding number of days.
	public static String addNoOfDaystoGivenDateAndPlanType(String date, String planSubCategoryType) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dateParse = LocalDate.parse(date, formatter);
		Month month = dateParse.getMonth();
		boolean b = dateParse.isLeapYear();
	//  System.out.println(month.length(b));
		boolean subscriptionPlan = (planSubCategoryType.equals("FREE") || planSubCategoryType.equals("PERSONAL"));
	    int monthValue = month.length(b);
		switch (monthValue) {
            case 28: 
				return (subscriptionPlan) ? 
			formatter.format(dateParse.plusDays(18)) : formatter.format(dateParse.plusDays(79));
            case 29:
				return (subscriptionPlan) ? 
			formatter.format(dateParse.plusDays(19)) : formatter.format(dateParse.plusDays(80));
            case 30:
				return (subscriptionPlan) ? 
			formatter.format(dateParse.plusDays(20)) : formatter.format(dateParse.plusDays(81));
			case 31:
			return (subscriptionPlan) ? 
			formatter.format(dateParse.plusDays(21)) : formatter.format(dateParse.plusDays(82));
            default:
                throw new DateTimeNotExistException("INVALID DATE \n" + "ADD_SUBSCRIPTION_FAILED INVALID_DATE");
        }
	}
}
