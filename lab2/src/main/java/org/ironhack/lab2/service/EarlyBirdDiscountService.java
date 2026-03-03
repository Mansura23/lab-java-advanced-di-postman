package org.ironhack.lab2.service;

import org.ironhack.lab2.exception.ExceptionCheckingNegativeNum;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EarlyBirdDiscountService {

    public String calculateDiscount(String startDateStr, String endDateStr) {
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        if (daysBetween <= 0) {
            throw new ExceptionCheckingNegativeNum("daysBetween can't be negative");
        }

        if (daysBetween <= 30) {
            return "You get 15% discount";
        }
        else{
            return "You can't get 15% discount";
        }


    }
}
