package com.salesianostriana.dam.TRIANA_TOURIST.dto.Category;

import com.salesianostriana.dam.TRIANA_TOURIST.dto.POI.CreatedPOIDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.model.Category;
import com.salesianostriana.dam.TRIANA_TOURIST.model.POI;
import org.springframework.stereotype.Component;

@Component
public class ConverterCategoryDTO {
    public Category convertPOIDto(CreatedCategoryDTO createdCategoryDTO) {
        return Category.builder()
                .name(createdCategoryDTO.getName())
                .build();

    }
}
