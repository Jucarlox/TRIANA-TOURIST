package com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones;

import com.salesianostriana.dam.TRIANA_TOURIST.validacion.validadores.CategoryNameUniqueValueMatchValitor;
import com.salesianostriana.dam.TRIANA_TOURIST.validacion.validadores.RouteNameUniqueValueMatchValitor;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RouteNameUniqueValueMatchValitor.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface RouteNameUniqueValueMatch {
    String message() default "No puede tener la misma ruta";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String nameRouteField();
}
