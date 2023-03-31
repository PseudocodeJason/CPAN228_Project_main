package com.cpan252.clotheswarehouse.controller;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpan252.clotheswarehouse.model.Cloth;
import com.cpan252.clotheswarehouse.model.Cloth.Brand;
import com.cpan252.clotheswarehouse.model.User;
import com.cpan252.clotheswarehouse.repository.ClothRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/add")
public class AddClothesController {

    @Autowired
    private ClothRepository clothRepository;

    @GetMapping
    public String add() {
        return "add";
    }

    @ModelAttribute
    public void animes(Model model) {
        var brands = EnumSet.allOf(Brand.class);
        model.addAttribute("brand", brands);
        log.info("brand converted to string:  {}", brands);
    }

    @ModelAttribute
    // This model attribute has a lifetime of a request
    public Cloth cloth() {
        return Cloth
                .builder()
                .build();
    } 

    @PostMapping
    public String processClothAddition(@Valid Cloth cloth, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }
        log.info("Processing cloth: {}", cloth);
        clothRepository.save(cloth);
        return "redirect:/clothlist";
    }

    @PostMapping("/deleteAllClothes")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String processClothesDeletion(@AuthenticationPrincipal User user) {
        log.info("Deleting all clothes for user: {}", user.getAuthorities());
        clothRepository.deleteAll();
        return "redirect:/add";
    }
}
