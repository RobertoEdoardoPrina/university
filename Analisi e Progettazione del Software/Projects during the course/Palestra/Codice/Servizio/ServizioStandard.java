package Servizio;

import Palestra.Area;
import Utente.Persona;
import Utente.PersonalTrainer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ServizioStandard extends Servizio{

    private HashSet<Persona> partecipanti;
    private final int numeroMassimoPartecipanti;

    public ServizioStandard(String nome, List<LocalDate> dateSvolgimento, LocalTime oraInizio, LocalTime oraFine, List<Area> aree, PersonalTrainer trainer, int numeroMassimoPartecipanti) {
        super(nome, dateSvolgimento, oraInizio, oraFine, aree, trainer);
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public void aggiungiPartecipante(Persona p){
        partecipanti.add(p);
    }

    public void rimuoviPartecipante(Persona p){
        partecipanti.remove(p);
    }

    public boolean verificaDisponibilità(){
        return partecipanti.size() < numeroMassimoPartecipanti;
    }
    public HashSet<Persona> getPartecipanti() {
        return partecipanti;
    }
    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

}
