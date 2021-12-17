package com.salesianostriana.dam.TRIANA_TOURIST.controller;

import com.salesianostriana.dam.TRIANA_TOURIST.model.POI;
import com.salesianostriana.dam.TRIANA_TOURIST.services.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class POIController {
    private final POIService poiService;

    @GetMapping
    public ResponseEntity<List<POI>> findAll(){
        return ResponseEntity.ok().body(poiService.findAll());
    }

}
