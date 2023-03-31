package com.cpan252.clotheswarehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ClothesManagment {

    @GetMapping
    public String clothesManagment(){
        return "clothesManagment";
    }
}
