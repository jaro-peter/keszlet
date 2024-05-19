package com.jaro.keszlet;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class KeszletController {

    private final KeszletRepository keszletRepository;

    @Autowired
    public KeszletController(KeszletRepository keszletRepository) {
        this.keszletRepository = keszletRepository;
    }

    @GetMapping("/products")
    public List<Product> getPruducts() {
        return keszletRepository.findAll();
    }

    @PostMapping("/products")
    public void createProduct(@RequestBody PruductDto pruductDto) {
        Product product = new Product();
        product.setNev(pruductDto.getNev());
        product.setAr(pruductDto.getAr());
        product.setMennyiseg(pruductDto.getMennyiseg());
        keszletRepository.save(product);
    }

}
