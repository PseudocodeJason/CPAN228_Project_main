package com.cpan252.clotheswarehouse.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cpan252.clotheswarehouse.model.dto.ItemDto;
import com.cpan252.clotheswarehouse.model.dto.ItemSearchByNameDto;


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
    public List<ItemDto> getDistributionCentreItems(@PathVariable int centreId){
        return Arrays.asList(restTemplate.getForObject("http://localhost:8082/api/DistributionCentre/" + centreId + "/items", 
        ItemDto[].class));
    }

    @ModelAttribute("centreId")
    public int getWarehouseID(@PathVariable int centreId){
        return centreId;
    }

    @PostMapping("/delete/{itemId}")
    public String deleteItem(@PathVariable int centreId, @PathVariable int itemId){
        restTemplate.delete("http://localhost:8082/api/DistributionCentre/{centreId}/items/{itemId}", centreId, itemId);
        return "redirect:/admin/centre/" + centreId;
    }

    @PostMapping
    public String itemsFiltered(@ModelAttribute ItemSearchByNameDto itemSearchByNameDto, Model model, @PathVariable int centreId){
        var brand = itemSearchByNameDto.getBrand();
        var item = itemSearchByNameDto.getName();
        List<ItemDto> filteredItems = Arrays.asList(restTemplate.getForObject("http://localhost:8082/api/DistributionCentre/{centreId}/items/by-brand-and-name/{brand}/{item}", ItemDto[].class, centreId, brand, item));
        model.addAttribute("items", filteredItems);
        return "items";
    }

    @PostMapping("/clear")
    public String itemsFilteredClear(Model model, @PathVariable int centreId){
        List<ItemDto> allitems = Arrays.asList(restTemplate.getForObject("http://localhost:8082/api/DistributionCentre/"+ centreId + "/items", ItemDto[].class));
        model.addAttribute("items", allitems);
        return "items";

    }
}
