package com.scand.coffeeshopboot.services;

import com.scand.coffeeshopboot.domain.Order;
import com.scand.coffeeshopboot.domain.OrderItem;
import com.scand.coffeeshopboot.repository.CoffeeRepository;
import com.scand.coffeeshopboot.repository.OrderItemRepository;
import com.scand.coffeeshopboot.repository.OrderRepository;
import com.scand.coffeeshopboot.to.CoffeeToConfirm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class OrderService {

    private List<CoffeeToConfirm> pendingCoffeeOrder = new ArrayList<>();
    private BigDecimal totalOrderPrice;

    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;

    private final CoffeeRepository coffeeRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository, CoffeeRepository coffeeRepository) {

        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.coffeeRepository = coffeeRepository;
    }

    public void finishOrder(String customerName, String customerPhone, String customerAddress) {

        Order savedOrder = orderRepository.save(new Order(Collections.emptyList(), totalOrderPrice));

        List<OrderItem> orderItems = new ArrayList<>();
        for (CoffeeToConfirm pendingCoffee : pendingCoffeeOrder) {
            orderItems.add(
                    new OrderItem(
                            coffeeRepository.findById(Long.valueOf(pendingCoffee.getCoffeeId())).get(),
                            savedOrder,
                            Integer.valueOf(pendingCoffee.getTotalQuantity())
                    )
            );
        }

        orderItemRepository.saveAll(orderItems);

        pendingCoffeeOrder.clear();
        totalOrderPrice = BigDecimal.ZERO;
    }

    public List<CoffeeToConfirm> getPendingCoffeeOrder() {

        return pendingCoffeeOrder;
    }

    public BigDecimal getTotalOrderPrice() {

        return totalOrderPrice;
    }

    public List<Order> retrieveSavedOrders() {

        return orderRepository.findAll();
    }

    public void parseOrderInfo(String[] coffeeNames, String[] coffeeDescriptions, String[] coffeePrices,
                               String[] coffeeIds, String[] totalQuantities, String[] totalPrices) {

        BigDecimal totalPrice = new BigDecimal(0);

        List<CoffeeToConfirm> coffees = new ArrayList<>();
        for (int i = 0; i < totalQuantities.length; i++) {
            if (totalQuantities[i].equals("0")) {
                continue;
            }

            coffees.add(new CoffeeToConfirm(
                    coffeeIds[i],
                    coffeeNames[i],
                    coffeePrices[i],
                    coffeeDescriptions[i],
                    totalQuantities[i]
            ));

            totalPrice = totalPrice.add(new BigDecimal(totalPrices[i]));
        }

        pendingCoffeeOrder = coffees;
        totalOrderPrice = totalPrice;
    }
}
