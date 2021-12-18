package com.salesianostriana.dam.TRIANA_TOURIST.dto.Route;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetRouteDTO {
    private Long id;
    private String name;
    private List<String> nombrePOI;
}
