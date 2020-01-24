package com.scand.coffeeshopboot.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Table(name="coffees")
public class Coffee{

    public Coffee(Long id, String name, String description, BigDecimal price) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Coffee() {

    }

    public Coffee(String name, String description, BigDecimal price) {

        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

}