package com.salesianostriana.dam.TRIANA_TOURIST.controller;

import com.salesianostriana.dam.TRIANA_TOURIST.dto.Category.CreatedCategoryDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.POI.CreatedPOIDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.model.Category;
import com.salesianostriana.dam.TRIANA_TOURIST.model.POI;
import com.salesianostriana.dam.TRIANA_TOURIST.services.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoriaService categoriaService;

    @GetMapping("/")
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok().body(categoriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findOne(@PathVariable Long id){
        return ResponseEntity.ok().body(categoriaService.findOne(id));
    }

    @PostMapping("/")
    public Category created(@Valid @RequestBody CreatedCategoryDTO createdCategoryDTO) {
        return categoriaService.created(createdCategoryDTO);
    }

    @PutMapping("/{id}")
    public Category edit(@Valid @RequestBody CreatedCategoryDTO createdCategoryDTO, @PathVariable Long id){
        return categoriaService.edit(createdCategoryDTO, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return categoriaService.delete(id);
    }
}
