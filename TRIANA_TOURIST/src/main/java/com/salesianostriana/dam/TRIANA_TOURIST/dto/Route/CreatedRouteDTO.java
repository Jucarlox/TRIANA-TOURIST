package com.salesianostriana.dam.TRIANA_TOURIST.dto.Route;

import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.RouteNameUniqueValueMatch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@RouteNameUniqueValueMatch(
        nameRouteField = "name",
        message = "{Route.name.unique}"
)
public class CreatedRouteDTO {
    private String name;
}
