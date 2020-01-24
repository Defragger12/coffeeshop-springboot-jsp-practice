package com.scand.coffeeshopboot.controllers;

import com.scand.coffeeshopboot.controllers.OrderController;
import com.scand.coffeeshopboot.services.OrderService;
import com.scand.coffeeshopboot.to.CoffeeToConfirm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @WithMockUser(value = "root")
    @Test
    public void displayOrder() throws Exception {

        List<CoffeeToConfirm> testCoffeeOrder = new ArrayList<>();
        testCoffeeOrder.add(new CoffeeToConfirm());

        BigDecimal testPrice = new BigDecimal(1);

        when(orderService.getPendingCoffeeOrder()).thenReturn(testCoffeeOrder);
        when(orderService.getTotalOrderPrice()).thenReturn(testPrice);

        this.mockMvc.perform(get("/order")
                .param("coffeeName", "test")
                .param("coffeeDescription", "test")
                .param("coffeePrice", "0")
                .param("coffeeId", "0")
                .param("totalQuantity", "0")
                .param("totalPrice", "0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("coffeeList", testCoffeeOrder))
                .andExpect(model().attribute("finalPrice", testPrice))
                .andExpect(forwardedUrl("/views/confirmOrder.jsp"))
                .andExpect(status().isOk());

    }

    @WithMockUser(value = "root")
    @Test
    public void finishOrder() throws Exception {

        this.mockMvc.perform(post("/order")
                .param("customer_name", "test")
                .param("customer_phone", "test")
                .param("customer_address", "test"))
                .andDo(print())
                .andExpect(forwardedUrl("/views/congratulation.jsp"))
                .andExpect(status().isOk());
    }
}