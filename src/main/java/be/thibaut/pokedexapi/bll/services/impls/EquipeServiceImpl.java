package be.thibaut.pokedexapi.bll.services.impls;

import be.thibaut.pokedexapi.bll.exceptions.equipe.EquipeNotFoundException;
import be.thibaut.pokedexapi.bll.services.EquipeService;
import be.thibaut.pokedexapi.dal.entities.EquipeEntity;
import be.thibaut.pokedexapi.dal.repositories.EquipeRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipeServiceImpl implements EquipeService {

    private final EquipeRepository equipeRepository;
    private final AuditorAware<String> auditorAware;

    private String currentUser() {
        return auditorAware.getCurrentAuditor().orElseThrow();
    }


    @Override
    @Transactional(readOnly = true)
    public List<EquipeEntity> findAll() {
        return equipeRepository.findByCreatedBy(currentUser());
    }

    @Override
    @Transactional(readOnly = true)
    public EquipeEntity findById(Long id) {

        Optional<EquipeEntity> equipe = equipeRepository.findByIdAndCreatedBy(id, currentUser());

        if (equipe.isEmpty()) {
            throw new EquipeNotFoundException("L'équipe avec l'id " + id + " n'existe pas.");
        }

        return equipe.get();
    }

    @Override
    @Transactional
    public EquipeEntity create(String nom) {
        EquipeEntity equipe = new EquipeEntity();

        equipe.setNom(nom);

        return equipeRepository.save(equipe);
    }

    @Override
    @Transactional
    public EquipeEntity rename(Long id, String nom) {
        EquipeEntity equipe = findById(id);

        equipe.setNom(nom);

        return equipeRepository.save(equipe);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        EquipeEntity equipe = findById(id);

        equipeRepository.delete(equipe);
    }
}
