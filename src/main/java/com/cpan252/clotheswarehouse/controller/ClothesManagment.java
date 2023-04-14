package com.cpan252.clotheswarehouse.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cpan252.clotheswarehouse.model.dto.DistributionCentreDto;

@Controller
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:8082")
public class ClothesManagment {
    private RestTemplate restTemplate;
 
    public ClothesManagment(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String clothesManagment(){
        return "clothesManagment";
    }

    @ModelAttribute("centres")
    public List<DistributionCentreDto> getDistributionCentre(){
        var centres = restTemplate.getForObject("http://localhost:8082/api/DistributionCentres", DistributionCentreDto[].class);
        return Arrays.asList(centres);
    }
}
