package com.scand.coffeeshopboot.services;

import com.scand.coffeeshopboot.domain.Coffee;
import com.scand.coffeeshopboot.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository) {

        this.coffeeRepository = coffeeRepository;
    }

    public List<Coffee> getCoffeeList() {

        return coffeeRepository.findAll();
    }
}
