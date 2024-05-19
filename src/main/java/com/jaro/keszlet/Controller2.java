package com.jaro.keszlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/create-product")
public class Controller2 {

    @GetMapping
    public String createProduct(){
        return "create_product";
    }


}
