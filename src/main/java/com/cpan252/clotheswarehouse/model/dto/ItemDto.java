package com.cpan252.clotheswarehouse.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
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

    @JsonValue
    public String getBrandname() {
      return brandname;
    }

    @JsonCreator
    public static Brand fromString(String brandname) {
      for (Brand b : Brand.values()) {
        if (b.brandname.equalsIgnoreCase(brandname)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unknown brand name: " + brandname);
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
