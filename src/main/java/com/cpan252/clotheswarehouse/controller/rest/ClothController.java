package com.cpan252.clotheswarehouse.controller.rest;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cpan252.clotheswarehouse.model.Cloth;
import com.cpan252.clotheswarehouse.model.dto.CreateCloth;
import com.cpan252.clotheswarehouse.repository.ClothRepository;
import com.cpan252.clotheswarehouse.repository.ClothRepositoryPaginated;

import jakarta.validation.Valid;

@RestController
// essentially the full path is http://localhost:8080/api/clothes
@RequestMapping(path = "/api/clothes", produces = "application/json")
public class ClothController {
    private final ClothRepositoryPaginated clothRepositoryPaginated;

    private final ClothRepository clothRepository;

    public ClothController(ClothRepositoryPaginated clothRepositoryPaginated,
    ClothRepository clothRepository) {
        this.clothRepositoryPaginated = clothRepositoryPaginated;
        this.clothRepository = clothRepository;
    }

    @GetMapping
    public Iterable<Cloth> allClothes(@RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        if (!page.isPresent() || !size.isPresent()) {
            return clothRepository.findAll();
        } else {
            return clothRepositoryPaginated.findAll(PageRequest.of(page.get(), size.get()));
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCloth(@PathVariable("id") Long id) {
        clothRepository.deleteById(id);
    }

    @PostMapping
    public Cloth createCloth(@Valid @RequestBody CreateCloth cloth) {
        return clothRepository.save(cloth.toCloth());
    }

    @PutMapping("/{id}")
    public Cloth updateCloth(@PathVariable("id") Long id,
            @Valid @RequestBody CreateCloth cloth) {
        var clothToUpdate = clothRepository.findById(id).orElseThrow();
        clothToUpdate.setName(cloth.getName());
        clothToUpdate.setYearofcreation(cloth.getYearofcreation());
        clothToUpdate.setPrice(cloth.getPrice());
        clothToUpdate.setBrand(cloth.getBrand());
        return clothRepository.save(clothToUpdate);
    }
}
