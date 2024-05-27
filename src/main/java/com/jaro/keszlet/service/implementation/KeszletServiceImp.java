package com.jaro.keszlet.service.implementation;

import com.jaro.keszlet.model.Product;
import com.jaro.keszlet.repository.KeszletRepository;
import com.jaro.keszlet.service.KeszletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeszletServiceImp implements KeszletService {
    private KeszletRepository keszletRepository;

    @Autowired
    public KeszletServiceImp(KeszletRepository keszletRepository) {
        this.keszletRepository = keszletRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return keszletRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        keszletRepository.save(product);

    }
}
