package com.salesianostriana.dam.TRIANA_TOURIST.dto.Category;

import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.CategoryNameUniqueValueMatch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

@CategoryNameUniqueValueMatch(
        nameCategoryField = "name",
        message = "{Category.name.unique}"
)

public class CreatedCategoryDTO {
    @NotNull(message = "{Category.name.null}")
    private String name;
}
