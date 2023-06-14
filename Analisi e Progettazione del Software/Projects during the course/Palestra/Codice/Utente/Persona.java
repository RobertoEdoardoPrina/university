package Utente;

import Offerta.Abbonamento;
import Offerta.Offerta;
import Offerta.PacchettoIngressi;

import java.time.LocalDate;
import java.util.Objects;

public class Persona implements IPersonaSubscriber{

    private static Integer currentId = 0;
    protected String idPersona;
    private String nome;
    private String cognome;
    private boolean genere;
    private LocalDate dataDiNascita;
    private LocalDate dataUltimoAcquisto;
    private boolean notifiche;
    private PacchettoIngressi pacchettoIngressi;

    public Persona(){
        this.idPersona = currentId.toString();
        currentId++;
        dataUltimoAcquisto = LocalDate.now();
    }
    public Persona(String nome, String cognome, boolean genere, LocalDate dataDiNascita) {
        this.idPersona = currentId.toString();
        currentId++;
        this.nome = nome;
        this.cognome = cognome;
        this.genere = genere;
        this.dataDiNascita = dataDiNascita;
        this.dataUltimoAcquisto = LocalDate.now();
    }

    public void modificaDati(String nome, String cognome, boolean genere, LocalDate dataDiNascita){
        this.nome = nome;
        this.cognome = cognome;
        this.genere = genere;
        this.dataDiNascita = dataDiNascita;
        this.dataUltimoAcquisto = LocalDate.now();
    }

    @Override
    public void onScadenzaAbbonamento() {

    }

    @Override
    public void onNuovaOfferta() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return Objects.equals(idPersona, persona.idPersona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersona);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setGenere(boolean genere) {
        this.genere = genere;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public void setNotifiche(boolean notifiche) {
        this.notifiche = notifiche;
    }

    public void setPacchettoIngressi(PacchettoIngressi pacchettoIngressi) {
        this.pacchettoIngressi = pacchettoIngressi;
    }


    public String getIdPersona() {
        return idPersona;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public boolean isGenere() {
        return genere;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public LocalDate getDataUltimoAcquisto() {
        return dataUltimoAcquisto;
    }

    public boolean isNotifiche() {
        return notifiche;
    }

    public PacchettoIngressi getPacchettoIngressi() {
        return pacchettoIngressi;
    }
}
