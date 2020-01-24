package com.scand.coffeeshopboot.services;

import com.scand.coffeeshopboot.repository.CoffeeRepository;
import com.scand.coffeeshopboot.services.CoffeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoffeeServiceTest {

    @MockBean
    private CoffeeRepository coffeeRepository;

    @Autowired
    private CoffeeService coffeeService;

    @Test
    public void getCoffeeList() {

        assertEquals(coffeeService.getCoffeeList(), coffeeRepository.findAll());
    }
}