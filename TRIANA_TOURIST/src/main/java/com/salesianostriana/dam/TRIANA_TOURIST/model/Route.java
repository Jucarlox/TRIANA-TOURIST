package com.salesianostriana.dam.TRIANA_TOURIST.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Route {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JsonIgnore
    @Builder.Default
    @ManyToMany(mappedBy = "route")
    private List<POI> poiList=new ArrayList<>();


    public void removeRoute(List<POI>  poiList) {
        this.getPoiList().remove(poiList);
    }

    @PreRemove
    public void preRemove(){
        poiList.forEach(v -> v.setRoute(null));
    }
}
