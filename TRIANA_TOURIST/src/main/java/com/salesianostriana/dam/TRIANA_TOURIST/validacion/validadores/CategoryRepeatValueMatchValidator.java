package com.salesianostriana.dam.TRIANA_TOURIST.validacion.validadores;

import com.salesianostriana.dam.TRIANA_TOURIST.model.Category;
import com.salesianostriana.dam.TRIANA_TOURIST.model.Route;
import com.salesianostriana.dam.TRIANA_TOURIST.repository.CategoryRepository;
import com.salesianostriana.dam.TRIANA_TOURIST.repository.RouteRepository;
import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.CategoryRepeatValueMatch;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.PropertyAccessorFactory;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@RequiredArgsConstructor
public class CategoryRepeatValueMatchValidator implements ConstraintValidator<CategoryRepeatValueMatch, Object> {
    private CategoryRepository categoryRepository;

    private String idCategoryValue;
    @Override
    public void initialize(CategoryRepeatValueMatch constraintAnnotation) {
        idCategoryValue = constraintAnnotation.idCategoryField();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        if(categoryRepository==null) return true;
        Long idCategory = (Long) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(idCategoryValue);

        List<Category> categoryList = categoryRepository.findAll();

        if (categoryRepository.findById(idCategory).isPresent()) {

            categoryList.stream().map(c -> {
                if (c.getId().equals(idCategory)) {
                    return true;
                }
                return false;
            });
        }
        return false;
    }
}
