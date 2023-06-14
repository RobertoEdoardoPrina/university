package Offerta;

import java.time.LocalDate;

public class Abbonamento extends Offerta{

    private TipologiaAbbonamento tipologia;
    private LocalDate dataAcquisto;

    public Abbonamento(Offerta baseOffer, TipologiaAbbonamento tipologia){
        super(baseOffer.getNome(), baseOffer.getPrezzo());
        this.tipologia = tipologia;
        this.dataAcquisto = LocalDate.now();
    }

    public boolean isValid(){
        switch (tipologia) {
            case MENSILE -> {
                return dataAcquisto.plusMonths(1).isBefore(LocalDate.now());
            }
            case TRIMESTRALE -> {
                return dataAcquisto.plusMonths(3).isBefore(LocalDate.now());
            }
            case SEMESTRALE -> {
                return dataAcquisto.plusMonths(6).isBefore(LocalDate.now());
            }
            case ANNUALE -> {
                return dataAcquisto.plusMonths(12).isBefore(LocalDate.now());
            }
        }
        return false;
    }

    public TipologiaAbbonamento getTipologia() {
        return tipologia;
    }

    public LocalDate getDataAcquisto() {
        return dataAcquisto;
    }

    public void rinnovaAbbonamento(TipologiaAbbonamento tipologia){
        this.tipologia = tipologia;
        this.dataAcquisto = LocalDate.now();
    }

    public enum TipologiaAbbonamento{
        MENSILE,
        TRIMESTRALE,
        SEMESTRALE,
        ANNUALE
    }
}
