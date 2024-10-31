package samuelecastaldo.Progetto_java_settimana6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samuelecastaldo.Progetto_java_settimana6.entities.Dipendente;

import java.util.Optional;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    Optional<Dipendente> findByEmail(String email);
    Optional<Dipendente> findByUsername(String username);
}
