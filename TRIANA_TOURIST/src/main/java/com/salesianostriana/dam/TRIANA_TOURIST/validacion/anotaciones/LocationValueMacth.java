package com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones;


import com.salesianostriana.dam.TRIANA_TOURIST.validacion.validadores.LocationValueMacthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = LocationValueMacthValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface LocationValueMacth {

    String message() default "La localizacion no tiene altitud o latitud correspondientes";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String localizacionValue();
}
