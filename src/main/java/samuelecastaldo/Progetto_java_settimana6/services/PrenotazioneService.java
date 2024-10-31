package samuelecastaldo.Progetto_java_settimana6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samuelecastaldo.Progetto_java_settimana6.entities.Dipendente;
import samuelecastaldo.Progetto_java_settimana6.entities.Prenotazione;
import samuelecastaldo.Progetto_java_settimana6.entities.Viaggio;
import samuelecastaldo.Progetto_java_settimana6.exceptions.BadRequestException;
import samuelecastaldo.Progetto_java_settimana6.exceptions.NotFoundException;
import samuelecastaldo.Progetto_java_settimana6.payloads.NewPrenotazioneDTO;
import samuelecastaldo.Progetto_java_settimana6.repositories.PrenotazioneRepository;

import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private ViaggioService viaggioService;

    @Autowired
    private DipendenteService dipendenteService;

    //GET --------------------------------------------
    public List<Prenotazione> findAll() {
        return this.prenotazioneRepository.findAll();
    }

    public Prenotazione findById(long id) {
        return this.prenotazioneRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    //POST --------------------------------------------
    public Prenotazione save(NewPrenotazioneDTO body) {
        //Devo fare prima il controllo se sono presenti entrambi gli id
        Dipendente dipendente = this.dipendenteService.findById(body.id_dipendente());
        Viaggio viaggio = this.viaggioService.findById(body.id_viaggio());

        prenotazioneRepository.findByDipendenteAndDataPrenotazione(dipendente, body.dataPrenotazione())
                .ifPresent(existingPrenotazione -> {
                    throw new BadRequestException("Il dipendente ha già una prenotazione per questa data");
                });

        Prenotazione newPrenotazione = new Prenotazione(viaggio, dipendente, body.dataPrenotazione(), body.note(), body.preferenze());
        return this.prenotazioneRepository.save(newPrenotazione);
    }

    //PUT --------------------------------------------
    public Prenotazione findByIdAndUpdate(long id, NewPrenotazioneDTO body) {
        Prenotazione found = this.findById(id);

        found.setPreferenze(body.preferenze());
        found.setDataPrenotazione(body.dataPrenotazione());
        found.setNote(body.note());

        return this.prenotazioneRepository.save(found);
    }


    //DELETE --------------------------------------------
    public void findByIdAndDelete(long id) {
        Prenotazione found = this.findById(id);
        this.prenotazioneRepository.delete(found);
    }

}
