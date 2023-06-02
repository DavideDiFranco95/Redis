package co.develhope.redis.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Utente {
    private Long id;
    private String name;
    private String surname;
    private int age;
}
