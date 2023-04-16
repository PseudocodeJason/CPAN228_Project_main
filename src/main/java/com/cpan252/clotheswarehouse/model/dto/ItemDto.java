package com.cpan252.clotheswarehouse.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    public enum Brand {
        BALENCIAGA("Balenciaga"), STONEISLAND("Stone Island"), DIOR("Dior"), CHANEL("Chanel");

        private String brandname;

        private Brand(String brandname) {
            this.brandname = brandname;
        }

        public String getBrandname() {
            return brandname;
        }
    }
    
    private Long id;
    private String name;
    private Brand brand;
    private int yearofcreation;
    private BigDecimal price;

    private int quantity;
    
    private LocalDate createdAt = LocalDate.now();

    @JsonIgnore
    private DistributionCentreDto distributionCentreDto;
}
