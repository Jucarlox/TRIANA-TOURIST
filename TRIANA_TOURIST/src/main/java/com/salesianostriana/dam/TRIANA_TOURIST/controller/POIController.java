package com.salesianostriana.dam.TRIANA_TOURIST.controller;

import com.salesianostriana.dam.TRIANA_TOURIST.dto.POI.CreatedPOIDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.model.POI;
import com.salesianostriana.dam.TRIANA_TOURIST.services.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class POIController {
    private final POIService poiService;

    @GetMapping("/")
    public ResponseEntity<List<POI>> findAll(){
        return ResponseEntity.ok().body(poiService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<POI> findOne(@PathVariable Long id){
        return ResponseEntity.ok().body(poiService.findOne(id));
    }

    @PostMapping("/")
    public POI created(@Valid @RequestBody CreatedPOIDTO createdPOIDTO) {
        return poiService.created(createdPOIDTO);
    }

    @PutMapping("/{id}")
    public POI edit(@Valid @RequestBody CreatedPOIDTO createdPOIDTO, @PathVariable Long id){
        return poiService.edit(createdPOIDTO, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return poiService.delete(id);
    }


}
