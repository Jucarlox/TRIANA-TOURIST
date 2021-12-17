package com.salesianostriana.dam.TRIANA_TOURIST.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Interesa implements Serializable {
    @Builder.Default
    @EmbeddedId
    private InteresaPK id = new InteresaPK();

    @ManyToOne
    @MapsId("poi_id")
    @JoinColumn(name="poi_id", foreignKey = @ForeignKey(name = "FK_INTERESA_POI"))
    private POI poi;


    @ManyToOne
    @MapsId("route_id")
    @JoinColumn(name="route_id", foreignKey = @ForeignKey(name = "FK_INTERESA_ROUTE"))
    private Route route;
}
