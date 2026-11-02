package be.thibaut.pokedexapi.dal.repositories;

import be.thibaut.pokedexapi.dal.entities.EquipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EquipeRepository extends JpaRepository<EquipeEntity, Long> {
    List<EquipeEntity> findByCreatedBy(String createdBy);
    Optional<EquipeEntity> findByIdAndCreatedBy(Long id, String createdBy);

}
