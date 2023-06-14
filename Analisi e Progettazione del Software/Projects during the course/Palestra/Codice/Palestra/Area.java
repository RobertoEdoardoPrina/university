package Palestra;

import Utente.Cliente;

public class Area {
    private String nome;
    private boolean tipologia;

    public Area(String nome, boolean tipologia){
        this.nome = nome;
        this.tipologia = tipologia;
    }

    public boolean puòAccedere(Cliente cliente){
        return cliente.getTipologia();
    }

    public String getNome() {
        return nome;
    }

    public boolean isTipologia() {
        return tipologia;
    }
}
