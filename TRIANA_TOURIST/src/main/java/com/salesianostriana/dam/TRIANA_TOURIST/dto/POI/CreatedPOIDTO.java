package com.salesianostriana.dam.TRIANA_TOURIST.dto.POI;

import com.salesianostriana.dam.TRIANA_TOURIST.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedPOIDTO {

    private String name;
    private String location;
    @Lob
    private String descripcion;
    private LocalDate date;




    @NotNull(message = "{POI.coverPhoto.null}")
    private String coverPhoto;
    private String photo2;
    private String photo3;
}
