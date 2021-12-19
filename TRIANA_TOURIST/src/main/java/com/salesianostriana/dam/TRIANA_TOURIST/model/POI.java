package com.salesianostriana.dam.TRIANA_TOURIST.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

    private LocalDate date;


    @ManyToOne()
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "FK_POI_CATEGORY"), nullable = true)
    private Category category;

    @JsonIgnore
    @ManyToMany()
    private List<Route> route= new ArrayList<>();

    private String coverPhoto;
    private String photo2;
    private String photo3;






}
