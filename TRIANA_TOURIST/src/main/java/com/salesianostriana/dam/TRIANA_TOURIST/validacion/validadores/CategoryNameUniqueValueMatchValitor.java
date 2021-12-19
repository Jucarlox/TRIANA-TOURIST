package com.salesianostriana.dam.TRIANA_TOURIST.validacion.validadores;

import com.salesianostriana.dam.TRIANA_TOURIST.repository.CategoryRepository;
import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.CategoryNameUniqueValueMatch;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryNameUniqueValueMatchValitor implements ConstraintValidator<CategoryNameUniqueValueMatch, Object> {

    private String nameCategoriaField;
    @Autowired
    private CategoryRepository categoryRepository;

    public void initialize(CategoryNameUniqueValueMatch constraintAnnotation) {
        nameCategoriaField = constraintAnnotation.nameCategoryField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        String nameCategory= (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(nameCategoriaField);
        return StringUtils.hasText(nameCategory) && !categoryRepository.existsByName(nameCategory);
    }
}
