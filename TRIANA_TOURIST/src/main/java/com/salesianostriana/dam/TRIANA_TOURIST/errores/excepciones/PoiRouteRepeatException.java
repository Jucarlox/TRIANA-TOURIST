package com.salesianostriana.dam.TRIANA_TOURIST.errores.excepciones;

public class PoiRouteRepeatException extends EntityNotFoundException{
    public PoiRouteRepeatException(String id, Class clazz) {
        super(String.format("No se puede repetir el %s con ID: %s en la Route", clazz.getName(), id));
    }
}
