package com.cpan252.clotheswarehouse.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cpan252.clotheswarehouse.model.dto.DistributionCentreDto;
import com.cpan252.clotheswarehouse.model.dto.ItemDto;
import com.cpan252.clotheswarehouse.model.dto.ItemSearchByNameDto;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:8082")
public class ClothesManagment {
  private RestTemplate restTemplate;
  private List<ItemDto> items;

  public ClothesManagment(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    this.items = Arrays.asList(restTemplate.getForObject("http://localhost:8082/api/DistributionCentre/items", ItemDto[].class));
  }

  @GetMapping
  public String clothesManagment() {
    return "clothesManagment";
  }
  
  @ModelAttribute("items")
  public List<ItemDto> getDistributionCentre(){
      return items;
  }

  @PostMapping
  public String clothesManagementFiltered(@ModelAttribute ItemSearchByNameDto itemSearchByNameDto, Model model){
    var brand = itemSearchByNameDto.getBrand();
    var item = itemSearchByNameDto.getName();
    items = Arrays.asList(restTemplate.getForObject("http://localhost:8082/api/DistributionCentre/items/by-brand-and-name/{brand}/{item}", ItemDto[].class, brand, item));
    return "redirect:/admin";
  }

  @PostMapping("/clear")
  public String clothesManagementFilteredClear(){
    items = Arrays.asList(restTemplate.getForObject("http://localhost:8082/api/DistributionCentre/items", ItemDto[].class));
    return "redirect:/admin";
  }

}
