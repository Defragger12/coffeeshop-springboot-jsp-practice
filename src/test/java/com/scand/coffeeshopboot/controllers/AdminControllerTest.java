package com.scand.coffeeshopboot.controllers;

import com.scand.coffeeshopboot.controllers.AdminController;
import com.scand.coffeeshopboot.domain.Order;
import com.scand.coffeeshopboot.repository.OrderRepository;
import com.scand.coffeeshopboot.services.OrderService;
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
@WebMvcTest(AdminController.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @MockBean
    private OrderRepository orderRepository;

    @WithMockUser(value = "root")
    @Test
    public void displayOrders() throws Exception {

        List<Order> testOrders = new ArrayList<>();
        testOrders.add(new Order());

        when(orderService.retrieveSavedOrders()).thenReturn(testOrders);

        this.mockMvc.perform(get("/admin"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("orderList", testOrders));
    }
}