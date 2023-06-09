package co.develhope.redis.controllers;

import co.develhope.redis.entities.Utente;
import co.develhope.redis.entities.UtenteJPA;
import co.develhope.redis.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UtenteController {
    @Autowired
    private UtenteService utenteService;

    @PostMapping("create")
    public UtenteJPA newUtente(@RequestBody UtenteJPA newUtente) throws Exception{
        return utenteService.createUtente(newUtente);
    }
    @GetMapping("/getAll")
    public List<? extends Utente> getAllUtenti()throws Exception{
        return utenteService.readAllUtenti();
    }
    @GetMapping("/{id}")
    public Optional<UtenteJPA> getUtente(@PathVariable Long id)throws Exception{
        return utenteService.readUtenteByID(id);
    }

    @PutMapping("/{id}")
    public UtenteJPA updateUtente(@PathVariable Long id){
        return utenteService.updateUtenteByID(id);
    }
    @DeleteMapping("/{id}")
    public void deleteUtente(@PathVariable Long id)throws Exception{
        utenteService.deleteUtente(id);
    }
}
