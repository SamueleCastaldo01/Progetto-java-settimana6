package samuelecastaldo.Progetto_java_settimana6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samuelecastaldo.Progetto_java_settimana6.entities.Dipendente;
import samuelecastaldo.Progetto_java_settimana6.entities.Prenotazione;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    Optional<Prenotazione> findByDipendenteAndDataPrenotazione(Dipendente dipendente, LocalDate dataPrenotazione);
}
