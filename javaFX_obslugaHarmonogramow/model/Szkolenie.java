package model;


import java.util.Date;

public class Szkolenie {
    private String akronim;
    private Date data_od;
    private Date data_do;
    private String typ_szkolen;
    private String nazwa;

    public Szkolenie() {
    }

    public Szkolenie(String akronim, Date data_od, Date data_do, String typ_szkolen, String nazwa) {
    }

    public String getAkronim() {
        return akronim;
    }

    public void setAkronim(String akronim) {
        this.akronim = akronim;
    }

    public Date getData_od() {
        return data_od;
    }

    public void setData_od(Date data_od) {
        this.data_od = data_od;
    }

    public Date getData_do() {
        return data_do;
    }

    public void setData_do(Date data_do) {
        this.data_do = data_do;
    }

    public String getTyp_szkolen() {
        return typ_szkolen;
    }

    public void setTyp_szkolen(String typ_szkolen) {
        this.typ_szkolen = typ_szkolen;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Szkolenie{" +
                "akronim='" + akronim + '\'' +
                ", data_od=" + data_od +
                ", data_do=" + data_do +
                ", typ_szkolenia=" + typ_szkolen +
                ", nazwa_szkolenia='" + nazwa + '\'' +
                '}';
    }
}

