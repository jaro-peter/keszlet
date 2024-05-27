package com.jaro.keszlet.controller;

import com.jaro.keszlet.model.Product;
import com.jaro.keszlet.model.PruductDto;
import com.jaro.keszlet.service.KeszletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KeszletController {

    private final KeszletService keszletService;

    @Autowired
    public KeszletController(KeszletService keszletService) {
        this.keszletService = keszletService;
    }

    @GetMapping("/")
    public String showProducts(Model model) {
        model.addAttribute("products", keszletService.findAllProducts());
        return "product-list";
    }

    @GetMapping("/new-product")
    public String showAddProductForm(Product product) {
        return "add-product";
    }

    @PostMapping("/product")
    public String createProduct(PruductDto pruductDto, BindingResult result, Model model) {
        Product product = new Product();
        product.setNev(pruductDto.getNev());
        product.setAr(pruductDto.getAr());
        product.setMennyiseg(pruductDto.getMennyiseg());
        keszletService.saveProduct(product);
        return "redirect:/";
    }


}
