package com.salesianostriana.dam.TRIANA_TOURIST.dto.POI;

import com.salesianostriana.dam.TRIANA_TOURIST.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetPOIDTO {
    private Long id;
    private String name;
    private String location;
    @Lob
    private String descripcion;
    private LocalDate date;

    private Category category;
    private List<String> nombreRoutes;
    private String coverPhoto;
    private String photo2;
    private String photo3;
}
