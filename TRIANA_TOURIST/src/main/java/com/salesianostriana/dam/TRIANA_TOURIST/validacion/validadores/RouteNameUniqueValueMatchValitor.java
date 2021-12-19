package com.salesianostriana.dam.TRIANA_TOURIST.validacion.validadores;

import com.salesianostriana.dam.TRIANA_TOURIST.repository.CategoryRepository;
import com.salesianostriana.dam.TRIANA_TOURIST.repository.RouteRepository;
import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.CategoryNameUniqueValueMatch;
import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.RouteNameUniqueValueMatch;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RouteNameUniqueValueMatchValitor implements ConstraintValidator<RouteNameUniqueValueMatch, Object> {
    private String nameRouteField;
    @Autowired
    private RouteRepository routeRepository;

    public void initialize(RouteNameUniqueValueMatch constraintAnnotation) {
        nameRouteField = constraintAnnotation.nameRouteField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        String nameRoute= (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(nameRouteField);
        return StringUtils.hasText(nameRoute) && !routeRepository.existsByName(nameRoute);
    }
}
