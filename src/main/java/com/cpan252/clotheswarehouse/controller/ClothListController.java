package com.cpan252.clotheswarehouse.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import com.cpan252.clotheswarehouse.model.Cloth.Brand;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cpan252.clotheswarehouse.model.dto.ClothSearchByDateDto;
import com.cpan252.clotheswarehouse.repository.ClothRepository;
import com.cpan252.clotheswarehouse.repository.ClothRepositoryPaginated;

@Controller
@RequestMapping("/clothlist")
public class ClothListController {
  private static final int PAGE_SIZE = 4;
  private ClothRepository clothRepository;

  private ClothRepositoryPaginated clothRepositoryPaginated;

  public ClothListController(ClothRepository clothRepository,
      ClothRepositoryPaginated clothRepositoryPaginated) {
    this.clothRepository = clothRepository;
    this.clothRepositoryPaginated = clothRepositoryPaginated;
  }

  @GetMapping
  public String showCloths(Model model) {
    return "clothlist";
  }

  @ModelAttribute
  public void cloths(Model model) {
    var clothPage = clothRepositoryPaginated.findAll(PageRequest.of(0, PAGE_SIZE));
    model.addAttribute("cloths", clothPage);
    model.addAttribute("currentPage", clothPage.getNumber());
    model.addAttribute("totalPages", clothPage.getTotalPages());
  }

  @ModelAttribute
  public void clothsByDateDto(Model model) {
    model.addAttribute("clothsByDateDto", new ClothSearchByDateDto());
  }

  @PostMapping
  public String searchClothsByDate(@ModelAttribute ClothSearchByDateDto clothsByDateDto,
      Model model) {
    var brand = clothsByDateDto.getBrand();
    var year = clothsByDateDto.getYearofcreation();
    model.addAttribute("cloths", clothRepository.findByBrandAndYearofcreation(brand, year));
    return "clothlist";
  }

  @GetMapping("/switchPage")
  public String switchPage(Model model,
      @RequestParam("pageToSwitch") Optional<Integer> pageToSwitch) {
    var page = pageToSwitch.orElse(0);
    var totalPages = (int) model.getAttribute("totalPages");
    if (page < 0 || page >= totalPages) {
      return "clothlist";
    }
    var clothPage = clothRepositoryPaginated.findAll(PageRequest.of(pageToSwitch.orElse(0),
        PAGE_SIZE));
    model.addAttribute("cloths", clothPage.getContent());
    model.addAttribute("currentPage", clothPage.getNumber());
    return "clothlist";
  }
}
