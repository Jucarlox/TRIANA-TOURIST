package com.salesianostriana.dam.TRIANA_TOURIST.validacion.validadores;

import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.LocationValueMacth;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class LocationValueMacthValidator implements ConstraintValidator<LocationValueMacth, Object> {

    private String locationField;
    @Override
    public void initialize(LocationValueMacth constraintAnnotation) {
        locationField = constraintAnnotation.localizacionValue();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        String location= (String) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(locationField);
        String lonMatchAndLatMatch = "^([-+]?\\d{1,2}[.]\\d+),\\s*([-+]?\\d{1,3}[.]\\d+)$";

        return Pattern.matches(lonMatchAndLatMatch,location);
    }
}
