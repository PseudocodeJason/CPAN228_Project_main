package com.cpan252.clotheswarehouse.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cpan252.clotheswarehouse.model.dto.ItemDto;


@Controller
@RequestMapping("/admin/centre/{centreId}")
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
    public List<ItemDto> getDistributionCentreId(@PathVariable int centreId){
        var items = restTemplate.getForObject("http://localhost:8082/api/DistributionCentre/" + centreId + "/items", 
        ItemDto[].class);
        return Arrays.asList(items);
    }

    @ModelAttribute("centreId")
    public int getWarehouseID(@PathVariable int centreId){
        return centreId;
    }

    @PostMapping("/delete/{itemId}")
    public String deleteItem(@PathVariable int centreId, @PathVariable int itemId){
        restTemplate.delete("http://localhost:8082/api/DistributionCentre/{warehouseId}/items/{itemId}", centreId, itemId);
        return "redirect:/admin/centre/" + centreId;
    }
}
