package com.salesianostriana.dam.TRIANA_TOURIST.validacion.validadores;


import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.UrlValueMacht;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UrlValueMatchValidator implements ConstraintValidator<UrlValueMacht, Object> {

    private String coverPhotoField;
    private String photo2Field;
    private String photo3Field;
    @Override
    public void initialize(UrlValueMacht constraintAnnotation) {
        coverPhotoField = constraintAnnotation.coverPhotoValue();
        photo2Field = constraintAnnotation.photo2Value();
        photo3Field = constraintAnnotation.photo3Value();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        String coverPhoto=(String) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(coverPhotoField);
        String photo2=(String) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(photo2Field);
        String photo3=(String) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(photo3Field);

        if(coverPhoto==null)return true;

        if(coverPhoto.equals(photo2) || coverPhoto.equals(photo3) || photo2.equals(photo3) ){
            return false;
        }else return true;
    }
}
