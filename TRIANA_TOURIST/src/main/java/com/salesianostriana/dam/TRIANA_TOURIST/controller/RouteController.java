package com.salesianostriana.dam.TRIANA_TOURIST.controller;

import com.salesianostriana.dam.TRIANA_TOURIST.dto.POI.CreatedPOIDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.Route.CreatedRouteDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.Route.GetRouteDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.model.POI;
import com.salesianostriana.dam.TRIANA_TOURIST.model.Route;
import com.salesianostriana.dam.TRIANA_TOURIST.services.POIService;
import com.salesianostriana.dam.TRIANA_TOURIST.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {
    private final RouteService routeService;

    @GetMapping("/")
    public ResponseEntity<List<Route>> findAll(){
        return ResponseEntity.ok().body(routeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetRouteDTO> findOne(@PathVariable Long id){
        return ResponseEntity.ok().body(routeService.findOne(id));
    }

    @PostMapping("/")
    public Route created(@Valid @RequestBody CreatedRouteDTO createdRouteDTO) {
        return routeService.created(createdRouteDTO);
    }

    @PutMapping("/{id}")
    public Route edit(@Valid @RequestBody CreatedRouteDTO createdRouteDTO, @PathVariable Long id){
        return routeService.edit(createdRouteDTO, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return routeService.delete(id);
    }
}
