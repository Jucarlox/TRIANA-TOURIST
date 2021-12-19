package com.salesianostriana.dam.TRIANA_TOURIST.dto.POI;

import com.salesianostriana.dam.TRIANA_TOURIST.dto.Route.GetRouteDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.model.Category;
import com.salesianostriana.dam.TRIANA_TOURIST.model.POI;
import com.salesianostriana.dam.TRIANA_TOURIST.model.Route;
import com.salesianostriana.dam.TRIANA_TOURIST.services.CategoriaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public GetPOIDTO getePOIToPOIDto(POI poi){

        List<String> nombreRoute = new ArrayList<>();
        for (int i=0; i<poi.getRoute().size();i++){
            nombreRoute.add(poi.getRoute().get(i).getName());
        }

        return GetPOIDTO
                .builder()
                .id(poi.getId())
                .name(poi.getName())
                .descripcion(poi.getDescripcion())
                .location(poi.getLocation())
                .date(poi.getDate())
                .category(poi.getCategory())
                .nombreRoutes(nombreRoute)
                .coverPhoto(poi.getCoverPhoto())
                .photo2(poi.getPhoto2())
                .photo3(poi.getPhoto3())
                .build();

    }



    public POI convertPOICategoryDtoV1(CreatedPOIAndCategoryDTO createdPOIAndCategoryDTO) {
        return POI.builder()
                .name(createdPOIAndCategoryDTO.getName())
                .location(createdPOIAndCategoryDTO.getLocation())
                .descripcion(createdPOIAndCategoryDTO.getDescripcion())
                .date(createdPOIAndCategoryDTO.getDate())
                .coverPhoto(createdPOIAndCategoryDTO.getCoverPhoto())
                .photo2(createdPOIAndCategoryDTO.getPhoto2())
                .photo3(createdPOIAndCategoryDTO.getPhoto3())
                .build();
    }

    public Category convertPOICategoryDtoV2(CreatedPOIAndCategoryDTO createdPOIAndCategoryDTO) {
        return Category.builder()
                .name(createdPOIAndCategoryDTO.getNameCategory())
                .build();
    }
}
