package com.shop.kong.dto;

import com.shop.kong.entity.Product;

public class ProductDto extends Product {
    public String productId;

    public String name;

    public String description;

    private int quantity;

    private int price;
}
