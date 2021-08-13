package io.github.citiesapi.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estado")
@Data
public class State {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private String uf;

    private Integer ibge;


    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Country country;

    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;

}
