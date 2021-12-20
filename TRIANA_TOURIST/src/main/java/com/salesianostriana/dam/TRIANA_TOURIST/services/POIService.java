package com.salesianostriana.dam.TRIANA_TOURIST.services;

import com.salesianostriana.dam.TRIANA_TOURIST.dto.Category.ConverterCategoryDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.Category.CreatedCategoryDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.POI.ConverterPOIDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.POI.CreatedPOIAndCategoryDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.POI.CreatedPOIDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.POI.GetPOIDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.Route.GetRouteDTO;
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
    private final ConverterCategoryDTO converterCategoryDTO;
    public List<POI> findAll(){
        List<POI> result = repositorio.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(POI.class);

        } else {
            return result;
        }
    }


    public GetPOIDTO findOne(Long id){
        repositorio.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));
        return converterPOIDTO.getePOIToPOIDto(repositorio.findById(id).get());
    }

    public POI created(CreatedPOIDTO createdPOIDTO) {
        POI poi=converterPOIDTO.convertPOIDto(createdPOIDTO);
        Optional<Category> category= categoriaService.findById(createdPOIDTO.getCategory_id());
        if(category.isPresent()){
            poi.setCategory(category.get());
            return repositorio.save(poi);
        }else{
            throw new SingleEntityNotFoundException(createdPOIDTO.getCategory_id().toString(), Category.class);
        }

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

    public POI createPoiAndCategory(CreatedPOIAndCategoryDTO createdPOIAndCategoryDTO){

        POI poi=converterPOIDTO.convertPOICategoryDtoV1(createdPOIAndCategoryDTO);
        Category category=converterPOIDTO.convertPOICategoryDtoV2(createdPOIAndCategoryDTO);
        poi.addCategory(category);
        categoriaService.save(category);
        return repositorio.save(poi);


    }




}


