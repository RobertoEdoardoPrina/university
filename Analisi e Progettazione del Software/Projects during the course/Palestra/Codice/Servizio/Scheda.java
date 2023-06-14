package Servizio;

import java.util.ArrayList;

public class Scheda {
    private String nome;
    private String tipologia;
    private ArrayList<Esercizio> esercizi;

    public Scheda(String nome, String tipologia) {
        this.nome = nome;
        this.tipologia = tipologia;
    }

    public String getNome() {
        return nome;
    }

    public String getTipologia() {
        return tipologia;
    }

    public ArrayList<Esercizio> getEsercizi() {
        return esercizi;
    }

    public float getDurata(){
        float sum = 0;
        for(Esercizio es : esercizi){
            sum += es.getDuarata();
        }
        return sum;
    }
}
