package Servizio;

import Palestra.Area;
import Utente.PersonalTrainer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public abstract class Servizio {
    private DettagliServizio dettagliServizio;

    public Servizio(String nome, List<LocalDate> dateSvolgimento, LocalTime oraInizio, LocalTime oraFine, List<Area> aree, PersonalTrainer trainer){
        dettagliServizio = new DettagliServizio(nome, dateSvolgimento, oraInizio, oraFine, aree, trainer);
    }

    public DettagliServizio getDettagli(){
        return dettagliServizio;
    }
}
