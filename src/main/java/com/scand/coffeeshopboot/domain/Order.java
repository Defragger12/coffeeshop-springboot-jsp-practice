package com.scand.coffeeshopboot.domain;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name="orders")
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<OrderItem> items;

    private BigDecimal price;

    public Order() {

    }

    public Order(List<OrderItem> items, BigDecimal price) {

        this.items = items;
        this.price = price;
    }

}