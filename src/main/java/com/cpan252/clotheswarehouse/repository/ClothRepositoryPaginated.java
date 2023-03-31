package com.cpan252.clotheswarehouse.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cpan252.clotheswarehouse.model.Cloth;

@Repository
public interface ClothRepositoryPaginated extends PagingAndSortingRepository<Cloth, Long> {
    
}
