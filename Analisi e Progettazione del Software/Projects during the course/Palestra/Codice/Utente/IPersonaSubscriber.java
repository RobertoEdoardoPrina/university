package Utente;

import Offerta.Abbonamento;
import Offerta.Offerta;

public interface IPersonaSubscriber {
    public void onScadenzaAbbonamento();
    public void onNuovaOfferta();
}
