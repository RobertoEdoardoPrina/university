package Utente;

import Offerta.Abbonamento.TipologiaAbbonamento;

import java.time.LocalDate;
import java.time.LocalTime;

public class PersonalTrainer extends Persona {

    private float sovrapprezzo;
    private LocalTime oraInizio;
    private LocalTime oraFine;
    public PersonalTrainer(String nome, String cognome, boolean genere, LocalDate dataDiNascita, float sovrapprezzo, LocalTime oraInizio, LocalTime oraFine) {
        super(nome, cognome, genere, dataDiNascita);
        this.sovrapprezzo = sovrapprezzo;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
    }

    public float calcolaSovrapprezzo(TipologiaAbbonamento tipologia){
        switch (tipologia) {
            case MENSILE -> {
                return sovrapprezzo;
            }
            case TRIMESTRALE -> {
                return sovrapprezzo * 3;
            }
            case SEMESTRALE -> {
                return sovrapprezzo * 6;
            }
            case ANNUALE -> {
                return sovrapprezzo * 12;
            }
        }
        return 0;
    }

    public void setSovrapprezzo(float sovrapprezzo) {
        this.sovrapprezzo = sovrapprezzo;
    }

    public void setOraInizio(LocalTime oraInizio) {
        this.oraInizio = oraInizio;
    }

    public void setOraFine(LocalTime oraFine) {
        this.oraFine = oraFine;
    }

    public LocalTime getOraInizio() {
        return oraInizio;
    }

    public LocalTime getOraFine() {
        return oraFine;
    }
}
