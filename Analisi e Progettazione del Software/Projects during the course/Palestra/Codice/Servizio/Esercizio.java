package Servizio;

public class Esercizio {
    private String nome;
    private float duarata;
    private String recupero;
    private String tipologia;

    public Esercizio(String nome, float duarata, String recupero, String tipologia) {
        this.nome = nome;
        this.duarata = duarata;
        this.recupero = recupero;
        this.tipologia = tipologia;
    }

    public String getNome() {
        return nome;
    }

    public String getTipologia() {
        return tipologia;
    }

    public float getDuarata() {
        return duarata;
    }

    public String getRecupero() {
        return recupero;
    }
}
