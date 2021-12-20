package com.salesianostriana.dam.TRIANA_TOURIST.repository;

import com.salesianostriana.dam.TRIANA_TOURIST.model.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface POIRepository extends JpaRepository<POI, Long> {

    @Query(value = """
            select * from POI where category_id = :id
            """,nativeQuery = true)
    List<POI> allCategoryPOI(@Param("id") Long id);
}
