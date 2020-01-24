package com.scand.coffeeshopboot.controllers;

import com.scand.coffeeshopboot.controllers.CoffeeController;
import com.scand.coffeeshopboot.domain.Coffee;
import com.scand.coffeeshopboot.services.CoffeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CoffeeController.class)
public class CoffeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoffeeService coffeeService;

    @WithMockUser(value = "root")
    @Test
    public void displayCoffees() throws Exception {

        List<Coffee> testCoffees = new ArrayList<>();
        testCoffees.add(new Coffee());

        when(coffeeService.getCoffeeList()).thenReturn(testCoffees);

        this.mockMvc.perform(get("/coffeeList"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("coffeeList", testCoffees));
    }
}