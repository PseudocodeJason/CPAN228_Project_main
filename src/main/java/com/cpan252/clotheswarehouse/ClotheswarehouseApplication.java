package com.cpan252.clotheswarehouse;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cpan252.clotheswarehouse.model.Cloth;
import com.cpan252.clotheswarehouse.model.User;
import com.cpan252.clotheswarehouse.model.Cloth.Brand;
import com.cpan252.clotheswarehouse.repository.ClothRepository;
import com.cpan252.clotheswarehouse.repository.UserRepository;

@SpringBootApplication
public class ClotheswarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClotheswarehouseApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(ClothRepository repository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {

			repository.save(Cloth.builder()
			.name("Balenciaga_1")
			.brand(Brand.BALENCIAGA)
			.yearofcreation(2022)
			.price(new BigDecimal(42452.5)).quantity(1).build());

			repository.save(Cloth.builder()
			.name("Balenciaga_2")
			.brand(Brand.BALENCIAGA)
			.yearofcreation(2024)
			.price(new BigDecimal(12542.5)).quantity(1).build());

			repository.save(Cloth.builder()
			.name("Balenciaga_3")
			.brand(Brand.BALENCIAGA)
			.yearofcreation(2022)
			.price(new BigDecimal(42452.5)).quantity(1).build());

			repository.save(Cloth.builder()
			.name("Balenciaga_4")
			.brand(Brand.BALENCIAGA)
			.yearofcreation(2024)
			.price(new BigDecimal(4545247.5)).build());

			repository.save(Cloth.builder()
			.name("Balenciaga_5")
			.brand(Brand.BALENCIAGA)
			.yearofcreation(2024)
			.price(new BigDecimal(54452.45)).build());

			repository.save(Cloth.builder()
			.name("Dior_1")
			.brand(Brand.DIOR)
			.yearofcreation(2023)
			.price(new BigDecimal(101245.5)).build());

			repository.save(Cloth.builder()
			.name("Dior_2")
			.brand(Brand.DIOR)
			.yearofcreation(2023)
			.price(new BigDecimal(101245.5)).build());

			repository.save(Cloth.builder()
			.name("Dior_3")
			.brand(Brand.DIOR)
			.yearofcreation(2023)
			.price(new BigDecimal(101245.5)).build());

			repository.save(Cloth.builder()
			.name("Dior_4")
			.brand(Brand.DIOR)
			.yearofcreation(2023)
			.price(new BigDecimal(101245.5)).build());

			repository.save(Cloth.builder()
			.name("Chanel_1")
			.brand(Brand.CHANEL)
			.yearofcreation(2022)
			.price(new BigDecimal(542452.5)).build());

			repository.save(Cloth.builder()
			.name("Chanel_2")
			.brand(Brand.CHANEL)
			.yearofcreation(2024)
			.price(new BigDecimal(312345.5)).build());

			repository.save(Cloth.builder()
			.name("Chanel_3")
			.brand(Brand.CHANEL)
			.yearofcreation(2022)
			.price(new BigDecimal(542452.5)).build());

			repository.save(Cloth.builder()
			.name("Chanel_4")
			.brand(Brand.CHANEL)
			.yearofcreation(2024)
			.price(new BigDecimal(312345.5)).build());

			repository.save(Cloth.builder()
			.name("Stone Island_1")
			.brand(Brand.STONEISLAND)
			.yearofcreation(2022)
			.price(new BigDecimal(12015.5)).build());

			repository.save(Cloth.builder()
			.name("Stone Island_2")
			.brand(Brand.STONEISLAND)
			.yearofcreation(2024)
			.price(new BigDecimal(12012.5)).build());

			repository.save(Cloth.builder()
			.name("Stone Island_3")
			.brand(Brand.STONEISLAND)
			.yearofcreation(2022)
			.price(new BigDecimal(12015.5)).build());

			repository.save(Cloth.builder()
			.name("Stone Island_4")
			.brand(Brand.STONEISLAND)
			.yearofcreation(2024)
			.price(new BigDecimal(12012.5)).build());

			userRepository.save(User.builder()
			.username("admin")
			.password(passwordEncoder.encode("admin")).build());
		};
	}

}
