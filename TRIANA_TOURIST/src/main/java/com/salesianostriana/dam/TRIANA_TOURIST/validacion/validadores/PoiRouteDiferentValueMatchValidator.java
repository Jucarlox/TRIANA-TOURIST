package com.salesianostriana.dam.TRIANA_TOURIST.validacion.validadores;

import com.salesianostriana.dam.TRIANA_TOURIST.model.Route;
import com.salesianostriana.dam.TRIANA_TOURIST.repository.RouteRepository;
import com.salesianostriana.dam.TRIANA_TOURIST.validacion.anotaciones.PoiRouteDiferentValueMatch;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@RequiredArgsConstructor
public class PoiRouteDiferentValueMatchValidator  implements ConstraintValidator<PoiRouteDiferentValueMatch,String> {

    private RouteRepository routeRepository;

    private String idRoute;
    private String idPOI;

    @Override
    public void initialize(PoiRouteDiferentValueMatch constraintAnnotation) {
        idRoute = constraintAnnotation.idRoute();
        idPOI = constraintAnnotation.idPOI();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Long idRouteValue = (Long) PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(idRoute);
        Long idPOIValue = (Long) PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(idPOI);

        if (routeRepository.findById(idRouteValue).isPresent()) {
            Route ruta = routeRepository.findById(idRouteValue).get();
            ruta.getPoiList().stream().map(poi -> {
                if (poi.getId().equals(idPOIValue)) {
                    return true;
                }
                return false;
            });
        }
        return false;
    }
}
