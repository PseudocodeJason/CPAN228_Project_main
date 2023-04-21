package com.cpan252.clotheswarehouse.model.dto;

import com.cpan252.clotheswarehouse.model.Cloth.Brand;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemSearchByNameDto {
    private Brand brand;
    private String name;
}
