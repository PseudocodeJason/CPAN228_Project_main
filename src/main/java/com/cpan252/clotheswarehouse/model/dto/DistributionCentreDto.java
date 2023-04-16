package com.cpan252.clotheswarehouse.model.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistributionCentreDto {
    private int id;
    private String name;
    private int longitude;
    private int latitude;
    private List<ItemDto> item;
}
