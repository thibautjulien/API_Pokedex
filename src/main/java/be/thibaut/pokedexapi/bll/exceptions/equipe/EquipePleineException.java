package be.thibaut.pokedexapi.bll.exceptions.equipe;

import org.springframework.http.HttpStatus;

public class EquipePleineException extends EquipeException {
    public EquipePleineException() {
        super(HttpStatus.CONFLICT, "Une équipe ne peut contenir plus de 6 Pokémon");
    }

    public EquipePleineException(String body) {
        super(HttpStatus.CONFLICT, body);
    }
}
