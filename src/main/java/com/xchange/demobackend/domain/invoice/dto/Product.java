package com.xchange.demobackend.domain.invoice.dto;

public class Product{
    public String name;
    public double price;
    public String inStock;

    public Product(String name, double price, String inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }
}