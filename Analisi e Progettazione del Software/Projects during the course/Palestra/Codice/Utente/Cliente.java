package Utente;

import Offerta.Abbonamento;
import Services.GeneratoreTessere;
import Servizio.ServizioPersonalizzato;

import java.time.LocalDate;
import java.util.HashMap;

public class Cliente extends Persona{
    private boolean tipologia;
    private LocalDate dataUltimoAccesso;
    private HashMap<String, Integer> corsiSeguitiAnno;
    private int numeroIngressi;
    private Abbonamento abbonamento;

    private ServizioPersonalizzato servizioPersonalizzato;

    public Cliente(){
        super();
        this.idPersona = GeneratoreTessere.getInstance().generaCodice();
        tipologia = false;
    }
    public Cliente(String nome, String cognome, boolean genere, LocalDate dataDiNascita, Abbonamento abbonamento) {
        super(nome, cognome, genere, dataDiNascita);
        this.idPersona = GeneratoreTessere.getInstance().generaCodice();
        tipologia = false /*cliente NON fedele*/;
        this.abbonamento = abbonamento;
    }

    public void setTipologia(boolean tipologia) {
        this.tipologia = tipologia;
    }

    public boolean getTipologia(){
        return tipologia;
    }

    public Abbonamento getAbbonamento() {
        return abbonamento;
    }

    public void setAbbonamento(Abbonamento abbonamento) {
        this.abbonamento = abbonamento;
    }

    public void setServizioPersonalizzato(ServizioPersonalizzato servizioPersonalizzato) {
        this.servizioPersonalizzato = servizioPersonalizzato;
    }

    public ServizioPersonalizzato getServizioPersonalizzato() {
        return servizioPersonalizzato;
    }
}
