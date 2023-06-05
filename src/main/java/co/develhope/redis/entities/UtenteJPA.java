package co.develhope.redis.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class UtenteJPA extends Utente{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
