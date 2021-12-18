package com.salesianostriana.dam.TRIANA_TOURIST.services;

import com.salesianostriana.dam.TRIANA_TOURIST.dto.POI.CreatedPOIDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.Route.ConverterRouteDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.Route.CreatedRouteDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.dto.Route.GetRouteDTO;
import com.salesianostriana.dam.TRIANA_TOURIST.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.TRIANA_TOURIST.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.TRIANA_TOURIST.model.Category;
import com.salesianostriana.dam.TRIANA_TOURIST.model.POI;
import com.salesianostriana.dam.TRIANA_TOURIST.model.Route;
import com.salesianostriana.dam.TRIANA_TOURIST.repository.RouteRepository;
import com.salesianostriana.dam.TRIANA_TOURIST.services.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteService extends BaseService<Route, Long, RouteRepository> {
    private final ConverterRouteDTO converterRouteDTO;
    public List<Route> saveAll(Iterable<Route> list) {
        return repositorio.saveAll(list);
    }

    public List<Route> findAll(){
        List<Route> result = repositorio.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(POI.class);

        } else {
            return result;
        }
    }

    public GetRouteDTO findOne(Long id){
        repositorio.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));
        return converterRouteDTO.geteRouteToRouteDto(repositorio.findById(id).get());
    }

    public Route created(CreatedRouteDTO createdRouteDTO) {
        return repositorio.save(converterRouteDTO.convertRouteDto(createdRouteDTO));
    }

    public Route edit(CreatedRouteDTO createdRouteDTO, Long id) {
        Optional<Route> route = repositorio.findById(id);
        if (route.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), POI.class);
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
}
