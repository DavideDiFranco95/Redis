package co.develhope.redis.repositories;

import co.develhope.redis.entities.Utente;
import co.develhope.redis.entities.UtenteJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<UtenteJPA,Long> {
}
