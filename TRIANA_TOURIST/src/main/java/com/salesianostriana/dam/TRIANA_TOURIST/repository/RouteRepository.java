package com.salesianostriana.dam.TRIANA_TOURIST.repository;

import com.salesianostriana.dam.TRIANA_TOURIST.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository  extends JpaRepository<Route, Long> {
    boolean existsByName(String name);
}
