package co.develhope.redis.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "Utente", timeToLive = 60)
@Entity
@Table
public class UtenteRedis extends Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
