package org.ironhack.lab2.controller;

import org.ironhack.lab2.exception.ExceptionCheckingNull;
import org.ironhack.lab2.service.EarlyBirdDiscountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
@RequestMapping("/api/discount")
public class DiscountController {

    private  final EarlyBirdDiscountService discountService;

    public DiscountController(Optional<EarlyBirdDiscountService> discountService, EarlyBirdDiscountService discountService1) {
        this.discountService = discountService.orElseThrow(() -> new ExceptionCheckingNull("discountService cannot be null"));
    }

    @GetMapping()
    public String getDiscount(@RequestParam String startTime,@RequestParam String endTime) {
        if(discountService==null){
            return "That is disabled";
        }
        return discountService.calculateDiscount(startTime,endTime);

    }

}
