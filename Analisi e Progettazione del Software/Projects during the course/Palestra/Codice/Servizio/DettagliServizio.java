package Servizio;

import Palestra.Area;
import Utente.PersonalTrainer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DettagliServizio {
    private String nome;
    private ArrayList<LocalDate> dateSvolgimento;
    private LocalTime oraInizio;
    private LocalTime oraFine;

    private ArrayList<Area> aree;
    private PersonalTrainer trainer;

    public DettagliServizio(String nome, List<LocalDate> dateSvolgimento, LocalTime oraInizio, LocalTime oraFine, List<Area> aree, PersonalTrainer trainer){
        this.nome = nome;
        this.dateSvolgimento = new ArrayList<>(dateSvolgimento);;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.aree = new ArrayList<>(aree);
        this.trainer = trainer;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<LocalDate> getDateSvolgimento() {
        return dateSvolgimento;
    }

    public LocalTime getOraInizio() {
        return oraInizio;
    }

    public LocalTime getOraFine() {
        return oraFine;
    }

    public ArrayList<Area> getAree() {
        return aree;
    }

    public PersonalTrainer getTrainer() {
        return trainer;
    }
}
