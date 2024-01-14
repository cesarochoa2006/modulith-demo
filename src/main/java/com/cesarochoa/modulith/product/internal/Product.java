package com.cesarochoa.modulith.product.internal;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Product {
    private String name;
    private String description;
    private double price;
}
