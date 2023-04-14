package com.cpan252.clotheswarehouse.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistributionCentreDto {
    private long id;
    private String name;
    private String item;
    private int available;
    private int longitude;
    private int latitude;
}
