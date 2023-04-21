package com.cpan252.clotheswarehouse.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cloth {

    public enum Brand {
        BALENCIAGA("Balenciaga"), STONEISLAND("Stone Island"), DIOR("Dior"), CHANEL("Chanel");

        @JsonValue
        @NotBlank
        private String brandname;

        private Brand(String brandname) {
            this.brandname = brandname;
        }

        public String getBrandname() {
            return brandname;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String name;
    private Brand brand;
    @Min(2022)
    private int yearofcreation;
    @DecimalMin(value = "1000.1", inclusive = true)
    private BigDecimal price;
    private int quantity;

    @Builder.Default
    private LocalDate createdAt = LocalDate.now();
}
