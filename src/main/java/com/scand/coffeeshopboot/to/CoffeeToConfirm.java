package com.scand.coffeeshopboot.to;

import lombok.Data;

@Data
public class CoffeeToConfirm {

    public CoffeeToConfirm() {

    }

    private String coffeeId;

    private String coffeeName;

    private String coffeePrice;

    private String coffeeDescription;

    private String totalQuantity;

    public CoffeeToConfirm(String coffeeId, String coffeeName, String coffeePrice, String coffeeDescription, String totalQuantity) {

        this.coffeeId = coffeeId;
        this.coffeeName = coffeeName;
        this.coffeePrice = coffeePrice;
        this.coffeeDescription = coffeeDescription;
        this.totalQuantity = totalQuantity;
    }
}
