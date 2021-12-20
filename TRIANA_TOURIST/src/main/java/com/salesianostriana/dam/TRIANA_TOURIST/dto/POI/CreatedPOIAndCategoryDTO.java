package com.salesianostriana.dam.TRIANA_TOURIST.dto.POI;

import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.CategoryNameUniqueValueMatch;
import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.CategoryRepeatValueMatch;
import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.LocationValueMacth;
import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.UrlValueMacht;
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
@UrlValueMacht(
        coverPhotoValue = "coverPhoto",
        photo2Value = "photo2",
        photo3Value = "photo3",
        message = "{Poi.url.diferent}"
)
@LocationValueMacth(
        localizacionValue = "location",
        message = "{Poi.location}"
)

@CategoryRepeatValueMatch(
        idCategoryField = "category_id",
        message = "{Poi.category.repeat}"
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
