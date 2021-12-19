package com.salesianostriana.dam.TRIANA_TOURIST.dto.POI;

import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.CategoryNameUniqueValueMatch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor


@CategoryNameUniqueValueMatch(
        nameCategoryField = "nameCategory",
        message = "{Category.name.unique}"
)
public class CreatedPOIAndCategoryDTO {

    @NotBlank(message = "{POI.name.notBlank}")
    private String name;
    private String location;
    @Lob
    private String descripcion;
    private LocalDate date;




    @NotNull(message = "{POI.coverPhoto.null}")
    private String coverPhoto;
    private String photo2;
    private String photo3;


    @NotNull(message = "{Category.name.null}")
    private String nameCategory;
}
