package com.cpan252.clotheswarehouse.controller;

import java.util.EnumSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cpan252.clotheswarehouse.model.Cloth;
import com.cpan252.clotheswarehouse.model.Cloth.Brand;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/add/{centreId}")
public class AddItemController {
    
    private RestTemplate restTemplate;

    public AddItemController (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String addItem(){
        return "addItem";
    }

    @ModelAttribute
    // This model attribute has a lifetime of a request
    public Cloth cloth() {
        return Cloth
                .builder()
                .build();
    } 

    @ModelAttribute
    public void animes(Model model) {
        var brands = EnumSet.allOf(Brand.class);
        model.addAttribute("brand", brands);
        log.info("brand converted to string:  {}", brands);
    }

    @PostMapping
    public String addItemToDistributionCentre(@PathVariable int centreId, @Valid Cloth cloth, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }
        log.info("Processing item: {}", cloth);
        restTemplate.postForObject("http://localhost:8082/api/DistributionCentre/{centreId}/items", cloth, Cloth.class, centreId);
        return "redirect:/admin/centre/" + centreId;
    }
    

}
