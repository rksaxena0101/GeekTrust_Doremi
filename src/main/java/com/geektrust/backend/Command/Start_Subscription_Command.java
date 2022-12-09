package com.geektrust.backend.Command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import com.geektrust.backend.Repository.ISubscriptionRepository;

public class Start_Subscription_Command implements ICommand{

    private ISubscriptionRepository subscriptionRepository;
    
    public Start_Subscription_Command(ISubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public void execute(List<String> tokens) {
        String date = tokens.get(1);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        try {
            LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
            subscriptionRepository.save(localDate);
        } catch (DateTimeParseException e) {
            System.out.println("INVALID_DATE");
        }
    }
    
}
