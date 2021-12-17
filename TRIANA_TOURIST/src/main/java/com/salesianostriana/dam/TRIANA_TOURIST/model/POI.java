package com.salesianostriana.dam.TRIANA_TOURIST.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class POI {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String location;

    @Lob
    private String descripcion;
    private Date date;

    @ManyToOne()
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "FK_POI_CATEGORY"), nullable = true)
    private Category category;

    private String coverPhoto;
    private String photo2;
    private String photo3;

}
