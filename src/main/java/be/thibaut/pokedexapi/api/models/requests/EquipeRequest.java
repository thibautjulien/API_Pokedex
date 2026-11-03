package be.thibaut.pokedexapi.api.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EquipeRequest(
        @NotBlank(message = "Le nom de l'équipe est obligatoire.")
        @Size(max = 50, message = "Le nom de l'équipe ne peut pas dépasser 50 caractères.")
        String nom
) {
}
