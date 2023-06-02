package co.develhope.redis.repositories;

import co.develhope.redis.entities.UtenteJPA;
import co.develhope.redis.entities.UtenteRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRedisRepository extends CrudRepository<UtenteRedis,Long> {
}
