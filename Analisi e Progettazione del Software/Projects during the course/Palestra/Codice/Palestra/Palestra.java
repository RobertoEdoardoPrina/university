package Palestra;

import Offerta.Offerta;
import Offerta.PacchettoIngressi;
import Utente.Cliente;
import Servizio.Servizio;
import Servizio.ServizioStandard;
import Servizio.ServizioPersonalizzato;
import Servizio.DettagliServizio;
import Utente.Persona;
import Utente.PersonalTrainer;
import Offerta.Abbonamento;
import Offerta.Abbonamento.TipologiaAbbonamento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Palestra {
    private LocalTime orarioApertura;
    private LocalTime orarioChiusura;
    private final HashMap<String, Persona> utenti;
    private final ArrayList<Servizio> servizi;
    private final ArrayList<Offerta> offerte;
    private final ArrayList<Area> aree;

    public Palestra(LocalTime orarioApertura, LocalTime orarioChiusura){
        this.orarioApertura = orarioApertura;
        this.orarioChiusura = orarioChiusura;

        this.utenti = new HashMap<>();
        this.servizi = new ArrayList<>();
        this.aree = new ArrayList<>();
        this.offerte = new ArrayList<>();
    }

    public void inserisciNuovoUtente(String nome, String cognome, LocalDate dataDiNascita, boolean genere){
        Persona p = new Persona();
        inserisciDatiAnagrafici(p, nome, cognome, genere, dataDiNascita);
        utenti.put(p.getIdPersona(), p);
    }

    public void richiediServizioPersonalizzato(String idCliente){
        ((Cliente)utenti.get(idCliente)).setServizioPersonalizzato(new ServizioPersonalizzato("Servizio Personalizzato " + idCliente, null, null, null, null, null));
    }

    public void richiediTrainer(String idCliente, String idTrainer){
        ((Cliente)utenti.get(idCliente)).getServizioPersonalizzato().setSupervisore((PersonalTrainer)utenti.get(idTrainer));
    }

    public void cancellaServizio(int indiceServizio){
        servizi.remove(indiceServizio);
    }

    public void cancellaOfferta(int indiceOfferta){
        offerte.remove(indiceOfferta);
    }

    public void aggiungiOfferta(String nome, float prezzo){
        offerte.add(new Offerta(nome, prezzo) {});
    }

    public void aggiungiServizio(String nome, ArrayList<LocalDate> dateSvolgimento, LocalTime oraInizio, LocalTime oraFine, ArrayList<Area> areeSvolgimento, PersonalTrainer trainer, int numeroMassimoPartecipanti){
        servizi.add(new ServizioStandard(nome, dateSvolgimento, oraInizio, oraFine, areeSvolgimento, trainer, numeroMassimoPartecipanti));
    }
    public void acquistaPacchetto(String idUtente, int indiceOfferta, int numeroIngressi){
        if(Pagamento.getInstance.paga())
            utenti.get(idUtente).setPacchettoIngressi(new PacchettoIngressi(offerte.get(indiceOfferta), numeroIngressi));
    }

    public void acquistaAbbonamento(String idCliente, int indiceOfferta,TipologiaAbbonamento tipologia){
        ((Cliente)utenti.get(idCliente)).setAbbonamento(new Abbonamento(offerte.get(indiceOfferta), tipologia));
    }
    public void rinnovaAbbonamento(String idCliente, TipologiaAbbonamento tipologia){
        ((Cliente)utenti.get(idCliente)).getAbbonamento().rinnovaAbbonamento(tipologia);
    }
    public void cancellaPrenotazione(String idPersona, int indiceCorso){
        ((ServizioStandard)servizi.get(indiceCorso)).rimuoviPartecipante(utenti.get(idPersona));
    }
    public void inserisciDatiAnagrafici(Persona persona, String nome, String cognome, boolean genere, LocalDate dataDiNascita){
        persona.modificaDati(nome, cognome, genere, dataDiNascita);
    }

    public void prenotaCorso(String idPersona, int indiceServizioStandard){
        ((ServizioStandard)servizi.get(indiceServizioStandard)).aggiungiPartecipante(utenti.get(idPersona));
    }

    public boolean verificaDisponibilitàCorso(int indiceServizioStandard){
        return ((ServizioStandard)servizi.get(indiceServizioStandard)).verificaDisponibilità();
    }
    public List<Servizio> getListaServizi(){
        return servizi;
    }
    public LocalTime[] getOrarioTrainer(String idTrainer){
        return new LocalTime[2];
    }
    public DettagliServizio[] getOrario(){
        DettagliServizio[] d = new DettagliServizio[5];
        return servizi.stream().map((s) -> { return s.getDettagli(); }).toList().toArray(d);
    }

    public LocalTime[] getOrarioPalestra(){
        return new LocalTime[]{orarioApertura, orarioChiusura};
    }

    public List<PacchettoIngressi> getListaPacchetti(){
        return offerte.stream().filter((o) -> { return o.getClass() == PacchettoIngressi.class; }).map((o) -> { return (PacchettoIngressi)o; }).toList();
    }

    private void subscribe(Persona persona){
        persona.setNotifiche(true);
    }

    private void notitySubscribers(){
        utenti.forEach((k, v) -> { v.onNuovaOfferta(); });
    }
}
