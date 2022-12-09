package com.geektrust.backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.geektrust.backend.AppConfig.ApplicationConfig;
import com.geektrust.backend.Command.CommandInvoker;
import com.geektrust.backend.Exception.NoSuchCommandException;
import com.geektrust.backend.Factory.SubscriptionFactory;

public class App {

	public static SubscriptionFactory subscriptionFactory;

	public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            while (line != null) {
                List<String> tokens = Arrays.asList(line.split(" "));
                commandInvoker.executeCommand(tokens.get(0),tokens);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException | NoSuchCommandException e) {
            e.printStackTrace();
        }
    }

	//  //Return date in dd-MM-yyyy string format by adding number of days.
	//  public static String addNoOfDaystoGivenDateAndPlanType(String date, String planSubCategoryType) throws ParseException {
	// 	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	// 	LocalDate dateParse = LocalDate.parse(date, formatter);
	// 	Month month = dateParse.getMonth();
	// 	boolean b = dateParse.isLeapYear();
	// //  System.out.println(month.length(b));
	// 	boolean subscriptionPlan = (planSubCategoryType.equals("FREE") || planSubCategoryType.equals("PERSONAL"));
	//     int monthValue = month.length(b);
	// 	switch (monthValue) {
    //         case 28: 
	// 			return (subscriptionPlan) ? 
	// 		formatter.format(dateParse.plusDays(18)) : formatter.format(dateParse.plusDays(79));
    //         case 29:
	// 			return (subscriptionPlan) ? 
	// 		formatter.format(dateParse.plusDays(19)) : formatter.format(dateParse.plusDays(80));
    //         case 30:
	// 			return (subscriptionPlan) ? 
	// 		formatter.format(dateParse.plusDays(20)) : formatter.format(dateParse.plusDays(81));
	// 		case 31:
	// 		return (subscriptionPlan) ? 
	// 		formatter.format(dateParse.plusDays(21)) : formatter.format(dateParse.plusDays(82));
    //         default:
    //             throw new DateTimeNotExistException("INVALID DATE \n" + "ADD_SUBSCRIPTION_FAILED INVALID_DATE");
    //     }
	// }
}
