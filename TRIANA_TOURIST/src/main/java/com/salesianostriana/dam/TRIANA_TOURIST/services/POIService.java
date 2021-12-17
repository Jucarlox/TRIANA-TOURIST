package com.salesianostriana.dam.TRIANA_TOURIST.services;

import com.salesianostriana.dam.TRIANA_TOURIST.model.POI;
import com.salesianostriana.dam.TRIANA_TOURIST.repository.POIRepository;
import com.salesianostriana.dam.TRIANA_TOURIST.services.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class POIService extends BaseService<POI, Long, POIRepository> {



    public List<POI> findAll(){
        return repositorio.findAll();
    }
}


