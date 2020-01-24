package com.scand.coffeeshopboot.controllers;

import com.scand.coffeeshopboot.services.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CoffeeController {

    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {

        this.coffeeService = coffeeService;
    }

    @RequestMapping(value = "/coffeeList", method = RequestMethod.GET)
    public String displayCoffees(ModelMap model) {

        model.addAttribute("coffeeList", coffeeService.getCoffeeList());

        return "coffeeList";
    }
}
