package be.thibaut.pokedexapi.bll.services;

import be.thibaut.pokedexapi.dal.entities.EquipeEntity;

import java.util.List;

public interface EquipeService {
    List<EquipeEntity> findAll();

    EquipeEntity findById(Long id);

    EquipeEntity create(String nom);

    EquipeEntity rename(Long id, String nom);

    void delete(Long id);
}
