package Medico;

public class Medico {
    String Nome;
    String Cognome ;
    String CodiceFiscale;
    String Titolo;

    public Medico(String nome, String cognome, String codiceFiscale, String titolo) {
        Nome = nome;
        Cognome = cognome;
        CodiceFiscale = codiceFiscale;
        Titolo = titolo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getCodiceFiscale() {
        return CodiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        CodiceFiscale = codiceFiscale;
    }

    public String getTitolo() {
        return Titolo;
    }

    public void setTitolo(String titolo) {
        Titolo = titolo;
    }
}

