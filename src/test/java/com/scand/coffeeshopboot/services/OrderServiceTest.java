package com.scand.coffeeshopboot.services;

import com.scand.coffeeshopboot.repository.OrderItemRepository;
import com.scand.coffeeshopboot.repository.OrderRepository;
import com.scand.coffeeshopboot.services.OrderService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @BeforeClass
    public static void beforeClass() {

    }

    @Test
    public void finishOrder() {

        orderRepository.deleteAll();
        orderItemRepository.deleteAll();

        orderService.parseOrderInfo(
                new String[]{"coffeeName"},
                new String[]{"coffeeDescription"},
                new String[]{"100"},
                new String[]{"1"},
                new String[]{"5"},
                new String[]{"500"}
        );

        orderService.finishOrder("name", "phone", "address");

        assertEquals(1, orderRepository.findAll().size());
        assertEquals(1, orderService.retrieveSavedOrders().size());
        assertEquals(1, orderItemRepository.findAll().size());

        assertEquals(0, orderService.getPendingCoffeeOrder().size());
        assertNotNull(orderService.getTotalOrderPrice());
    }
}