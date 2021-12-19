package com.salesianostriana.dam.TRIANA_TOURIST.repository;

import com.salesianostriana.dam.TRIANA_TOURIST.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByName(String name);
}
