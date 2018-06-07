package model;

public class Kurs {

    private int kID;
    private String kNazwa;
    private int kIleDni;

    public Kurs(int kID, String kNazwa, int kIleDni) {
        this.kID = kID;
        this.kNazwa = kNazwa;
        this.kIleDni = kIleDni;
    }

    public Kurs(String kNazwa, int kIleDni) {
        this.kNazwa = kNazwa;
        this.kIleDni = kIleDni;
    }

    public int getkID() {
        return kID;
    }

    public void setkID(int kID) {
        this.kID = kID;
    }

    public String getkNazwa() {
        return kNazwa;
    }

    public void setkNazwa(String kNazwa) {
        this.kNazwa = kNazwa;
    }

    public int getkIleDni() {
        return kIleDni;
    }

    public void setkIleDni(int kIleDni) {
        this.kIleDni = kIleDni;
    }

}
