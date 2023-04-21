package com.cpan252.clotheswarehouse.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cpan252.clotheswarehouse.model.dto.ItemDto;


@Controller
@RequestMapping("/admin/centre/{warehouseId}")
public class ItemsController {
    
    private RestTemplate restTemplate;  
    
    public ItemsController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String item(){
        return "items";
    }
    
    @ModelAttribute("items")
    public List<ItemDto> getDistributionCentreId(@PathVariable int warehouseId){
        var items = restTemplate.getForObject("http://localhost:8082/api/DistributionCentre/" + warehouseId + "/items", 
        ItemDto[].class);
        return Arrays.asList(items);
    }

    
}
