package be.thibaut.pokedexapi.bll.exceptions.equipe;

import org.springframework.http.HttpStatus;

public class EquipeNotFoundException extends EquipeException {
    public EquipeNotFoundException() {
        super(HttpStatus.CONFLICT, "Team not found");
    }

    public EquipeNotFoundException(String body) {
        super(HttpStatus.CONFLICT, body);
    }
}
