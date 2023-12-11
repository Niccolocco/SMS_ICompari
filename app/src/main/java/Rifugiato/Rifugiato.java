package Rifugiato;

public class Rifugiato {

    String Nome;
    String Cognome;
    String Età;
    String Nazionalità;
    String CodiceFiscale;
    String Sesso;


    public Rifugiato(String nome, String cognome, String nazionalità, String codiceFiscale, String sesso, String età) {
        Nome = nome;
        Cognome = cognome;
        Età= età;
        Nazionalità= nazionalità;
        CodiceFiscale= codiceFiscale;
        Sesso=sesso;
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

    public String getEtà() {
        return Età;
    }

    public void setEtà(String età) {
        Età = età;
    }

    public String getNazionalità() {
        return Nazionalità;
    }

    public void setNazionalità(String nazionalità) {
        Nazionalità = nazionalità;
    }

    public String getCodiceFiscale() {
        return CodiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        CodiceFiscale = codiceFiscale;
    }

    public String getSesso() {
        return Sesso;
    }

    public void setSesso(String sesso) {
        Sesso = sesso;
    }

    @Override
    public String toString() {
        return "Rifugiato{" +
                "Nome='" + Nome + '\'' +
                ", Cognome='" + Cognome + '\'' +
                ", Età=" + Età +
                ", Nazionalità='" + Nazionalità + '\'' +
                ", CodiceFiscale='" + CodiceFiscale + '\'' +
                ", Sesso='" + Sesso + '\'' +
                '}';
    }


}
