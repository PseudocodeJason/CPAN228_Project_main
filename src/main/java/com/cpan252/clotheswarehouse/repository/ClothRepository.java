package com.cpan252.clotheswarehouse.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cpan252.clotheswarehouse.model.Cloth;
import com.cpan252.clotheswarehouse.model.Cloth.Brand;

public interface ClothRepository  extends CrudRepository<Cloth, Long>{
    List<Cloth> findByBrand(Brand brand);
    List<Cloth> findByNameStartsWithAndCreatedAtBetween(String name, LocalDate startDate, LocalDate endDate);
    List<Cloth> findByBrandAndYearofcreation(Brand brand, int yearofcreation);

}
