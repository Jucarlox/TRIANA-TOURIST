package com.salesianostriana.dam.TRIANA_TOURIST.dto.POI;

import com.salesianostriana.dam.TRIANA_TOURIST.model.Category;
import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.CategoryNameUniqueValueMatch;
import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.CategoryRepeatValueMatch;
import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.LocationValueMacth;
import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.UrlValueMacht;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
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


public class CreatedPOIDTO {

    @NotBlank(message = "{POI.name.notBlank}")
    private String name;

    private String location;
    @Lob
    private String descripcion;
    private LocalDate date;

    private Long category_id;


    @NotNull(message = "{POI.coverPhoto.null}")
    @URL
    private String coverPhoto;
    @URL
    private String photo2;
    @URL
    private String photo3;
}
