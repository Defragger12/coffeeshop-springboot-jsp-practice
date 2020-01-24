package com.scand.coffeeshopboot.controllers;

import com.scand.coffeeshopboot.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {

        this.orderService = orderService;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String displayOrder(
            ModelMap model,
            @RequestParam("coffeeName") String[] coffeeNames,
            @RequestParam("coffeeDescription") String[] coffeeDescriptions,
            @RequestParam("coffeePrice") String[] coffeePrices,
            @RequestParam("coffeeId") String[] coffeeIds,
            @RequestParam("totalQuantity") String[] totalQuantities,
            @RequestParam("totalPrice") String[] totalPrices
    ) {

        orderService.parseOrderInfo(
                coffeeNames,
                coffeeDescriptions,
                coffeePrices,
                coffeeIds,
                totalQuantities,
                totalPrices
        );

        model.addAttribute("coffeeList", orderService.getPendingCoffeeOrder());
        model.addAttribute("finalPrice", orderService.getTotalOrderPrice());

        return "confirmOrder";
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String finishOrder(
        @RequestParam("customer_name") String customerName,
        @RequestParam("customer_phone") String customerPhone,
        @RequestParam("customer_address") String customerAddress
    ) {

        orderService.finishOrder(customerName, customerPhone, customerAddress);

        return "congratulation";
    }
}
