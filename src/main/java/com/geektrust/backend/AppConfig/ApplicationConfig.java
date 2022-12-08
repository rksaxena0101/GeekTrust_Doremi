package com.geektrust.backend.AppConfig;

import com.geektrust.backend.Command.Add_Subscription_Command;
import com.geektrust.backend.Command.Add_TopUp_Command;
import com.geektrust.backend.Command.CommandInvoker;
import com.geektrust.backend.Command.Print_Renewal_Details_Command;
import com.geektrust.backend.Command.Start_Subscription_Command;
import com.geektrust.backend.Repository.ISubscriptionRepository;
import com.geektrust.backend.Repository.ISubscription_Category_Repository;
import com.geektrust.backend.Repository.Subscription_Category_Repository;
import com.geektrust.backend.Repository.Subscription_Repository;

public class ApplicationConfig {
   
    private final ISubscriptionRepository iSubscriptionRepository = new Subscription_Repository();
    private final ISubscription_Category_Repository iSubscription_Category_Repository = new Subscription_Category_Repository(iSubscriptionRepository);

    private final Start_Subscription_Command startSubscriptionCommand = new Start_Subscription_Command(iSubscriptionRepository);
    private final Add_Subscription_Command addSubscription = new Add_Subscription_Command(iSubscription_Category_Repository, iSubscriptionRepository);
    private final Add_TopUp_Command addTopUpCommand = new Add_TopUp_Command(iSubscriptionRepository,iSubscription_Category_Repository);
    private final Print_Renewal_Details_Command printRenewalDetails = new Print_Renewal_Details_Command(iSubscription_Category_Repository,iSubscriptionRepository);
    

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker() {
        
        commandInvoker.register("START_SUBSCRIPTION",startSubscriptionCommand);
        commandInvoker.register("ADD_SUBSCRIPTION",addSubscription);
        commandInvoker.register("ADD_TOPUP",addTopUpCommand);
        commandInvoker.register("PRINT_RENEWAL_DETAILS",printRenewalDetails);
       
        return commandInvoker;
    }
}

