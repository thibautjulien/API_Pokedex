package be.thibaut.pokedexapi.dal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "membre_equipe")
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class MembreEquipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer pokemonId;

    @Column(length = 30)
    private String surnom;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "equipe_id")
    private EquipeEntity equipe;
}
