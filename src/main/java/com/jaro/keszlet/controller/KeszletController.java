package com.jaro.keszlet.controller;

import com.jaro.keszlet.repository.KeszletRepository;
import com.jaro.keszlet.model.Product;
import com.jaro.keszlet.model.PruductDto;
import com.jaro.keszlet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller       //@Restcontroller

public class KeszletController {

    private final KeszletRepository keszletRepository;

    @Autowired
    public KeszletController(KeszletRepository keszletRepository) {
        this.keszletRepository = keszletRepository;
    }

    @GetMapping("/")
    public String showProducts(Model model) {
        model.addAttribute("products", keszletRepository.findAll());
        return "index";
    }

    @GetMapping("/new-product")
    public String showSignUpForm(Product product) {
        return "add-product";
    }

    @GetMapping("/products")
    public List<Product> getPruducts() {
        return keszletRepository.findAll();
    }

    @PostMapping("/product")
    public String createProduct(PruductDto pruductDto, BindingResult result, Model model) {
        Product product = new Product();
        product.setNev(pruductDto.getNev());
        product.setAr(pruductDto.getAr());
        product.setMennyiseg(pruductDto.getMennyiseg());
        keszletRepository.save(product);
        return "redirect:/";
    }
    @GetMapping("/registration")
    public String showAddUser(User user) {
        return "registration";
    }



}
