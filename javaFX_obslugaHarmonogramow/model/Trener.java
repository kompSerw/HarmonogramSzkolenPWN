package model;

public class Trener {

    private String Imie, Nazwisko, Inicjaly, Haslo;
    private int ID, Mentor;

    public Trener(int ID, String Imie, String Nazwisko, String Inicjaly, String Haslo, int Mentor) {
        this.ID = ID;
        this.Imie = Imie;
        this.Nazwisko = Nazwisko;
        this.Inicjaly = Inicjaly;
        this.Haslo = Haslo;
        this.Mentor = Mentor;
    }


    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public String getInicjaly() {
        return Inicjaly;
    }

    public void setInicjaly(String inicjaly) {
        Inicjaly = inicjaly;
    }

    public String getHaslo() {
        return Haslo;
    }

    public void setHaslo(String haslo) {
        Haslo = haslo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMentor() {
        return Mentor;
    }

    public void setMentor(int mentor) {
        Mentor = mentor;
    }
}
