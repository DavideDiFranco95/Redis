package co.develhope.redis.services;

import co.develhope.redis.entities.Utente;
import co.develhope.redis.entities.UtenteJPA;
import co.develhope.redis.entities.UtenteRedis;
import co.develhope.redis.repositories.UtenteRedisRepository;
import co.develhope.redis.repositories.UtenteRepositoryJPA;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    UtenteRepositoryJPA utenteRepositoryJPA;
    @Autowired
    UtenteRedisRepository utenteRedisRepository;

    public UtenteRedis convertData(UtenteJPA utenteJPA){
        UtenteRedis utenteRedis = new UtenteRedis();
        BeanUtils.copyProperties(utenteJPA,utenteRedis);
        return utenteRedis;
    }

    public UtenteJPA createUtente(UtenteJPA utente)throws Exception{
        try {
            if (utente==null) return null;
            utente.setId(null);
            return utenteRepositoryJPA.saveAndFlush(utente);
        }catch (Exception e){
            throw new Exception("Utente non trovato :(");
        }
    }
    public List<? extends Utente> readAllUtenti() throws Exception{
        List<UtenteJPA> utentiFromDB = utenteRepositoryJPA.findAll();
        if (utentiFromDB.isEmpty()) throw new Exception("Utenti non trovati :(");
        return utentiFromDB;
    }

    public Optional<UtenteJPA> readUtenteByID(long id) throws Exception {
        try {
            return utenteRepositoryJPA.findById(id);
        } catch (Exception e) {
            throw new Exception("ID non trovato :(");
        }
    }

    public UtenteJPA updateUtenteByID(long id){
        UtenteJPA newUtente = utenteRepositoryJPA.getReferenceById(id);
        return utenteRepositoryJPA.findById(id)
                .map(utente -> {
                    utente.setName(newUtente.getName());
                    utente.setSurname(newUtente.getSurname());
                    utente.setAge(newUtente.getAge());
                    return utenteRepositoryJPA.saveAndFlush(utente);
                })
                .orElseGet(() -> {
                    newUtente.setId(id);
                    return utenteRepositoryJPA.saveAndFlush(newUtente);
                });
    }

    public void deleteUtente(long id)throws Exception{
        try {
            utenteRepositoryJPA.deleteById(id);
        }catch(Exception e){
            throw new Exception("Impossibile trovare l'ID da cancellare");
        }
    }
}
