package com.salesianostriana.dam.TRIANA_TOURIST.services;

import com.salesianostriana.dam.TRIANA_TOURIST.dto.POI.ConverterPOIDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.POI.CreatedPOIDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.TRIANA_TOURIST.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.TRIANA_TOURIST.model.Category;
import com.salesianostriana.dam.TRIANA_TOURIST.model.POI;
import com.salesianostriana.dam.TRIANA_TOURIST.model.Route;
import com.salesianostriana.dam.TRIANA_TOURIST.repository.POIRepository;
import com.salesianostriana.dam.TRIANA_TOURIST.services.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class POIService extends BaseService<POI, Long, POIRepository> {

    private final ConverterPOIDTO converterPOIDTO;
    private final CategoriaService categoriaService;
    public List<POI> findAll(){
        List<POI> result = repositorio.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(POI.class);

        } else {
            return result;
        }
    }


    public POI findOne(Long id){
        return repositorio.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));
    }

    public POI created(CreatedPOIDTO createdPOIDTO) {
        return repositorio.save(converterPOIDTO.convertPOIDto(createdPOIDTO));
    }


    public POI edit(CreatedPOIDTO createdPOIDTO, Long id) {

        Optional<POI> poi = repositorio.findById(id);

        if (poi.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), POI.class);
        } else {
            return poi.map(e -> {
                e.setName(createdPOIDTO.getName());
                e.setDescripcion(createdPOIDTO.getDescripcion());
                e.setLocation(createdPOIDTO.getLocation());
                e.setDate(createdPOIDTO.getDate());
                e.setCoverPhoto(createdPOIDTO.getCoverPhoto());
                e.setPhoto2(createdPOIDTO.getPhoto2());
                e.setPhoto3(createdPOIDTO.getPhoto3());
                repositorio.save(e);
                return e;
            }).get();
        }
    }

    public ResponseEntity delete(Long id){
        Optional<POI> poi= repositorio.findById(id);
        if (poi.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            repositorio.delete(poi.get());
            return ResponseEntity.noContent().build();
        }

    }




}


