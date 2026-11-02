package be.thibaut.pokedexapi.bll.exceptions.equipe;

import be.thibaut.pokedexapi.bll.exceptions.PokedexException;
import org.springframework.http.HttpStatus;

public class EquipeException extends PokedexException {
    public EquipeException(HttpStatus status, Object body) {
        super(status, body, "equipe");
    }
}
