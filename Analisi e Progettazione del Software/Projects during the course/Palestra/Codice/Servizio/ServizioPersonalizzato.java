package Servizio;

import Palestra.Area;
import Utente.PersonalTrainer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ServizioPersonalizzato extends Servizio{

    private Scheda scheda;
    private PersonalTrainer supervisore;

    public ServizioPersonalizzato(String nome, List<LocalDate> dateSvolgimento, LocalTime oraInizio, LocalTime oraFine, List<Area> aree, PersonalTrainer trainer) {
        super(nome, dateSvolgimento, oraInizio, oraFine, aree, trainer);
    }

    public void setSupervisore(PersonalTrainer supervisore) {
        this.supervisore = supervisore;
    }

    public Scheda getScheda() {
        return scheda;
    }

    public PersonalTrainer getSupervisore() {
        return supervisore;
    }
}
