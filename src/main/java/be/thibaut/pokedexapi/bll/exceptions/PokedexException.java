package be.thibaut.pokedexapi.bll.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = false) @ToString
public class PokedexException extends RuntimeException {
    @Getter
    private String section;

    @Getter
    private final HttpStatus status;

    @Getter
    private final Object body;

    public PokedexException(HttpStatus status, Object body, String section) {
        super(String.valueOf(body));
        this.status = status;
        this.body = body;
        this.section = section;
    }
}
