package samuelecastaldo.Progetto_java_settimana6.payloads;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record NewViaggioDTO(
        @NotEmpty(message = "La destinazione è obbligatoria")
        String destinazione,
        @NotNull(message = "La data è obbligatoria")
        @Future(message = "La data non deve essere passata")
        LocalDate data,
        @NotEmpty(message = "La stato è obbligatoria")
        @Pattern(regexp = "^(in programma|completato)$", message = "Lo stato deve essere 'in programma' o 'completato'")
        String stato
) {
    //abbiamo messo anche che deve essere per forza scritto in programma o completato
}
