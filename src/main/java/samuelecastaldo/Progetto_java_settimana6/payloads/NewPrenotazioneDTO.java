package samuelecastaldo.Progetto_java_settimana6.payloads;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record NewPrenotazioneDTO(
        @NotNull(message = "L' id del viaggio è obbligatorio!")
        long id_viaggio,
        @NotNull(message = "L'id del dipendente è obbligatorio!")
        long id_dipendente,
        @NotNull(message = "La data di prenotazione è obbligatorio!")
        LocalDate dataPrenotazione,
        String note,
        String preferenze
) {
}
