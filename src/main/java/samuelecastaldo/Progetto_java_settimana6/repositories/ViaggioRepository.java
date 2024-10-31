package samuelecastaldo.Progetto_java_settimana6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import samuelecastaldo.Progetto_java_settimana6.entities.Viaggio;

@Repository
public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {
}
