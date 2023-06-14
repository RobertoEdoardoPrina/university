package Offerta;

public abstract class Offerta {
    private String nome;
    private float prezzo;

    public Offerta(String nome, float prezzo){
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getNome(){
        return nome;
    }

    public float getPrezzo(){
        return prezzo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
}
