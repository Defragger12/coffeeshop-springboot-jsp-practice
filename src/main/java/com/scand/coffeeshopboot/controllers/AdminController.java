package com.scand.coffeeshopboot.controllers;

import com.scand.coffeeshopboot.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    private final OrderService orderService;

    @Autowired
    public AdminController(OrderService orderService) {

        this.orderService = orderService;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String displayOrders(ModelMap model) {

        model.addAttribute("orderList", orderService.retrieveSavedOrders());

        return "admin/admin";
    }
}