package com.salesianostriana.dam.TRIANA_TOURIST.services;

import com.salesianostriana.dam.TRIANA_TOURIST.dto.Category.ConverterCategoryDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.Category.CreatedCategoryDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.POI.CreatedPOIDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.Route.CreatedRouteDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.TRIANA_TOURIST.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.TRIANA_TOURIST.model.Category;
import com.salesianostriana.dam.TRIANA_TOURIST.model.POI;
import com.salesianostriana.dam.TRIANA_TOURIST.model.Route;
import com.salesianostriana.dam.TRIANA_TOURIST.repository.CategoryRepository;
import com.salesianostriana.dam.TRIANA_TOURIST.repository.POIRepository;
import com.salesianostriana.dam.TRIANA_TOURIST.services.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoriaService extends BaseService<Category, Long, CategoryRepository> {
    private final ConverterCategoryDTO converterCategoryDTO;
    private final POIRepository poiRepository;
    public List<Category> findAll(){
        List<Category> result = repositorio.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(Category.class);

        } else {
            return result;
        }
    }

    public Category findOne(Long id){
        return repositorio.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));
    }

    public Category created(CreatedCategoryDTO createdCategoryDTO) {
        return repositorio.save(converterCategoryDTO.convertPOIDto(createdCategoryDTO));
    }

    public Category edit(CreatedCategoryDTO createdCategoryDTO, Long id) {
        Optional<Category> category = repositorio.findById(id);
        if (category.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), POI.class);
        } else {
            return category.map(e -> {
                e.setName(createdCategoryDTO.getName());
                repositorio.save(e);
                return e;
            }).get();
        }
    }

    public ResponseEntity delete(Long id){
        Optional<Category> category= repositorio.findById(id);
        if (category.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{

            repositorio.delete(category.get());
            return ResponseEntity.noContent().build();
        }

    }
}
