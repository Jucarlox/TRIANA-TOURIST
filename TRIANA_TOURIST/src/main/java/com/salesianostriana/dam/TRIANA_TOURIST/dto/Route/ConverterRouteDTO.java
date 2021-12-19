package com.salesianostriana.dam.TRIANA_TOURIST.dto.Route;

import com.salesianostriana.dam.TRIANA_TOURIST.dto.POI.CreatedPOIDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.model.POI;
import com.salesianostriana.dam.TRIANA_TOURIST.model.Route;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConverterRouteDTO {

    public GetRouteDTO geteRouteToRouteDto(Route ro){

        List<String> nombrePOI = new ArrayList<>();

        for (int i=0; i<ro.getPoiList().size();i++){
            nombrePOI.add(ro.getPoiList().get(i).getName());
        }

        return GetRouteDTO
                .builder()
                .id(ro.getId())
                .name(ro.getName())
                .nombrePOI(nombrePOI)
                .build();

    }


    public Route convertRouteDto(CreatedRouteDTO createdRouteDTO) {
        return Route.builder()
                .name(createdRouteDTO.getName())
                .build();

    }
}
