package Offerta;

public class PacchettoIngressi extends Offerta{
    private int numeroIngressi;
    public PacchettoIngressi(Offerta baseOffer, int numeroIngressi) {
        super(baseOffer.getNome(), baseOffer.getPrezzo());
        this.numeroIngressi = numeroIngressi;
    }

    public void decrementaNumeroIngressi(){
        this.numeroIngressi--;
    }

    public int getNumeroIngressi() {
        return numeroIngressi;
    }
}
