package com.salesianostriana.dam.TRIANA_TOURIST;

import com.salesianostriana.dam.TRIANA_TOURIST.model.POI;
import com.salesianostriana.dam.TRIANA_TOURIST.model.Route;
import com.salesianostriana.dam.TRIANA_TOURIST.services.CategoriaService;
import com.salesianostriana.dam.TRIANA_TOURIST.services.POIService;
import com.salesianostriana.dam.TRIANA_TOURIST.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MainPrueba {
    private final POIService poiService;
    private final RouteService routeService;
    private final CategoriaService categoriaService;


    @PostConstruct
    public void test() {
        POI poi=POI.builder()
                .name("Museo del Padro")
                .location("Madrid")
                .descripcion("Uno de los museos más importantes del mundo, así como uno de los más visitados, y está considerada la institución cultural más importante de España")
                .date(LocalDate.parse("1975-03-17"))
                .category(categoriaService.findById(1L).get())
                .route(new ArrayList<>())
                .coverPhoto("https://upload.wikimedia.org/wikipedia/commons/6/68/Museo_del_Prado_2016_%2825185969599%29.jpg")
                .photo2("https://upload.wikimedia.org/wikipedia/commons/6/68/Museo_del_Prado_2016_%2825185969599%29.jpg")
                .build();


        List<Route> rutas = List.of(
                Route.builder().name("Puente de Triana").build(),
                Route.builder().name("Guadalquivir").build()

        );

        routeService.saveAll(rutas);

        poi.getRoute().addAll(rutas);

        poiService.save(poi);
    }
}
