package samuelecastaldo.Progetto_java_settimana6.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggio;
    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;
    @Column(name = "data_prenotazione")
    private LocalDate dataPrenotazione;
    private String note;
    private String preferenze;

    public  Prenotazione() {}

    public Prenotazione(Viaggio viaggio, Dipendente dipendente, LocalDate dataPrenotazione, String note, String preferenze) {
        this.viaggio = viaggio;
        this.dipendente = dipendente;
        this.dataPrenotazione = dataPrenotazione;
        this.note = note;
        this.preferenze = preferenze;
    }

    public long getId() {
        return id;
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public LocalDate getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(LocalDate dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPreferenze() {
        return preferenze;
    }

    public void setPreferenze(String preferenze) {
        this.preferenze = preferenze;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", viaggio=" + viaggio +
                ", dipendente=" + dipendente +
                ", dataPrenotazione=" + dataPrenotazione +
                ", note='" + note + '\'' +
                ", preferenze='" + preferenze + '\'' +
                '}';
    }
}
