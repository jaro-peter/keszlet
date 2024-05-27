package com.jaro.keszlet.service;

import com.jaro.keszlet.model.Product;

import java.util.List;

public interface KeszletService {

    public List<Product> findAllProducts();
    public void saveProduct(Product product);
}
