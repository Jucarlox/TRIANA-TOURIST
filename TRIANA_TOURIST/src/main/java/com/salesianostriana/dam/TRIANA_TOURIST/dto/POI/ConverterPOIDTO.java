package com.salesianostriana.dam.TRIANA_TOURIST.dto.POI;

import com.salesianostriana.dam.TRIANA_TOURIST.model.POI;
import com.salesianostriana.dam.TRIANA_TOURIST.services.CategoriaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component

public class ConverterPOIDTO {


    public POI convertPOIDto(CreatedPOIDTO createdPOIDTO) {
        return POI.builder()
                .name(createdPOIDTO.getName())
                .location(createdPOIDTO.getLocation())
                .descripcion(createdPOIDTO.getDescripcion())
                .date(createdPOIDTO.getDate())
                .coverPhoto(createdPOIDTO.getCoverPhoto())
                .photo2(createdPOIDTO.getPhoto2())
                .photo3(createdPOIDTO.getPhoto3())
                .build();

    }
}
