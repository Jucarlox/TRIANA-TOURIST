package com.salesianostriana.dam.TRIANA_TOURIST.services;

import com.salesianostriana.dam.TRIANA_TOURIST.dto.POI.CreatedPOIDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.Route.ConverterRouteDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.Route.CreatedRouteDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.Route.GetRouteDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.TRIANA_TOURIST.errores.excepciones.PoiRouteRepeatException;
import com.salesianostriana.dam.TRIANA_TOURIST.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.TRIANA_TOURIST.model.Category;
import com.salesianostriana.dam.TRIANA_TOURIST.model.POI;
import com.salesianostriana.dam.TRIANA_TOURIST.model.Route;
import com.salesianostriana.dam.TRIANA_TOURIST.repository.RouteRepository;
import com.salesianostriana.dam.TRIANA_TOURIST.services.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteService extends BaseService<Route, Long, RouteRepository> {
    private final ConverterRouteDTO converterRouteDTO;
    private final POIService poiService;

    public List<Route> saveAll(Iterable<Route> list) {
        return repositorio.saveAll(list);
    }

    public List<Route> findAll(){
        List<Route> result = repositorio.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(Route.class);

        } else {
            return result;
        }
    }

    public Route findOne(Long id){
        return repositorio.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));
    }

    public Route created(CreatedRouteDTO createdRouteDTO) {
        return repositorio.save(converterRouteDTO.convertRouteDto(createdRouteDTO));
    }

    public Route edit(CreatedRouteDTO createdRouteDTO, Long id) {
        Optional<Route> route = repositorio.findById(id);
        if (route.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Route.class);
        } else {
            return route.map(e -> {
                e.setName(createdRouteDTO.getName());
                repositorio.save(e);
                return e;
            }).get();
        }
    }

    public ResponseEntity delete(Long id){
        Optional<Route> route= repositorio.findById(id);
        if (route.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            route.get().removeRoute(route.get().getPoiList());
            repositorio.delete(route.get());
            return ResponseEntity.noContent().build();
        }

    }


    public ResponseEntity<Route> addPoi(Long id, Long id2){
        Optional<Route> route= repositorio.findById(id);
        Optional<POI> poi= poiService.findById(id2);

        if(!route.isEmpty() && !poi.isEmpty()){

            route.get().getPoiList().stream().forEach(m->{
                if(m.getId().equals(id2)) throw new PoiRouteRepeatException(id2.toString(), Route.class);
            });
            route.get().getPoiList().add(poi.get());
            repositorio.save(route.get());
            poi.get().getRoute().add(route.get());
            poiService.save(poi.get());
            return  ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(route.get());
        }else{
           if(route.isEmpty()){
               throw new SingleEntityNotFoundException(id.toString(), Route.class);
           }else{
               throw new SingleEntityNotFoundException(id2.toString(), POI.class);
           }
        }

    }
}
