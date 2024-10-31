package samuelecastaldo.Progetto_java_settimana6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelecastaldo.Progetto_java_settimana6.entities.Dipendente;
import samuelecastaldo.Progetto_java_settimana6.exceptions.BadRequestException;
import samuelecastaldo.Progetto_java_settimana6.exceptions.NotFoundException;
import samuelecastaldo.Progetto_java_settimana6.payloads.NewDipendenteDTO;
import samuelecastaldo.Progetto_java_settimana6.repositories.DipendenteRepository;

import java.util.List;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public List<Dipendente> findAll() {
        return this.dipendenteRepository.findAll();
    }

    public Dipendente findById(long id) {
        return this.dipendenteRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Dipendente save(NewDipendenteDTO body) {
        //controllo se ci sta già un altro con la stessa email
        this.dipendenteRepository.findByEmail(body.email()).ifPresent(
                user -> {
                    throw new BadRequestException("Email " + body.email() + " già in uso!");
                }
        );
        //controllo anche dell'username, deve essere univoco
        this.dipendenteRepository.findByUsername(body.username()).ifPresent(
                user -> {
                    throw new BadRequestException("Username " + body.username() + " è già in uso!");
                }
        );
        Dipendente newAutore = new Dipendente(body.username(), body.nome(), body.cognome(), body.email(), body.avatarUrl());
        return this.dipendenteRepository.save(newAutore);
    }


}
