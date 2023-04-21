package com.cpan252.clotheswarehouse.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cpan252.clotheswarehouse.model.dto.DistributionCentreDto;

@Controller
@RequestMapping("/admin/centres")
@CrossOrigin(origins = "http://localhost:8082")
public class DistributionCentreController {
    
    private RestTemplate restTemplate;

    public DistributionCentreController (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String distributionCentres(){
        return "DistributionCentre";
    }

    @ModelAttribute("centres")
    public List<DistributionCentreDto> getDistributionCentre(){
        var centres = restTemplate.getForObject("http://localhost:8082/api/DistributionCentre", DistributionCentreDto[].class);
        return Arrays.asList(centres);
    }
    
    @PostMapping("/delete/{centreId}")
    public String deleteDistributionCentre(@PathVariable int centreId) {
        restTemplate.delete("http://localhost:8082/api/DistributionCentre/{centreId}", centreId);
        return "redirect:/admin/centres";
    }

}
