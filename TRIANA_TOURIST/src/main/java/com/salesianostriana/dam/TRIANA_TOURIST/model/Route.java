package com.salesianostriana.dam.TRIANA_TOURIST.model;

import lombok.*;

import javax.persistence.*;
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

    @OneToMany
    private List<Interesa> interesa;
}
