package co.develhope.redis.services;

import co.develhope.redis.entities.Utente;
import co.develhope.redis.entities.UtenteJPA;
import co.develhope.redis.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    UtenteRepository utenteRepository;

    public UtenteService(UtenteRepository utenteRepository){
        this.utenteRepository = utenteRepository;
    }

    public UtenteJPA newUtente(UtenteJPA utente)throws Exception{
        try {
            if (utente==null) return null;
            return utenteRepository.saveAndFlush(utente);
        }catch (Exception e){
            throw new Exception("Utente non trovato :(");
        }
    }
    public List<UtenteJPA> getUtenti() throws Exception{
        List<UtenteJPA> utentiFromDB = utenteRepository.findAll();
        if (utentiFromDB.isEmpty()) throw new Exception("Utenti non trovati :(");
        return utentiFromDB;
    }

    public Optional<UtenteJPA> getUtenteByID(long id) throws Exception {
        try {
            return utenteRepository.findById(id);
        } catch (Exception e) {
            throw new Exception("ID non trovato :(");
        }
    }

    public UtenteJPA replaceUtenteByID(long id){
        UtenteJPA newUtente = utenteRepository.getReferenceById(id);
        return utenteRepository.findById(id)
                .map(utente -> {
                    utente.setName(newUtente.getName());
                    utente.setSurname(newUtente.getSurname());
                    utente.setAge(newUtente.getAge());
                    return utenteRepository.saveAndFlush(utente);
                })
                .orElseGet(() -> {
                    newUtente.setId(id);
                    return utenteRepository.saveAndFlush(newUtente);
                });
    }

    public void deleteUtente(long id)throws Exception{
        try {
            utenteRepository.deleteById(id);
        }catch(Exception e){
            throw new Exception("Impossibile trovare l'ID da cancellare");
        }
    }
}
