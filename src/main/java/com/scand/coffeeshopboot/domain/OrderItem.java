package com.scand.coffeeshopboot.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="orderitems")
public class OrderItem{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public OrderItem() {

    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coffee_id")
    private Coffee coffee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private Integer quantity;

    public OrderItem(Coffee coffee, Order order, Integer quantity) {

        this.coffee = coffee;
        this.order = order;
        this.quantity = quantity;
    }
}