package com.example.cc2_kaddour;
import java.io.Serializable;
public class Entreprise implements Serializable{
    private int ID;
    private String Raison_Sociale;
    private String Adresse ;
    private double Capitale ;
    public Entreprise() {
    }

    public Entreprise(int ID, String Raison_Sociale, String Adresse, double Capitale) {
        this.ID = ID;
        this.Raison_Sociale = Raison_Sociale;
        this.Adresse = Adresse;
        this.Capitale = Capitale;
    }

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = ID;
    }

    public String getRaison_Sociale() {
        return Raison_Sociale;
    }

    public void setRaison_Sociale(String Raison_Sociale) {
        this.Raison_Sociale = Raison_Sociale;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        this.Adresse = Adresse;
    }

    public double getCapitale() {
        return Capitale;
    }

    public void setCapitale(double Capitale) {
        this.Capitale = Capitale;
    }
}
