package sample;

import java.io.Serializable;

public class Plat implements Serializable {
    protected int reference;
    protected String nom;
    protected String détail;
    protected double prix;
    static int id;

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDétail() {
        return détail;
    }

    public void setDétail(String détail) {
        this.détail = détail;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Plat(String nom, String détail, double prix) {
        this.nom = nom;
        this.détail = détail;
        this.prix = prix;
        this.reference = id;
        Plat.id++;
    }

    public Plat(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
        this.reference = id;
        Plat.id++;
    }

    public Plat() {
        this.reference = id;
        Plat.id++;

    }


    @Override
    public String toString() {
        return
                "Référence=" + reference + "\t"+
                "Nom=" + nom + "\t"+
                "Détail=" + détail + "\t"+
                "Prix=" + prix + "DA" ;
    }

    public boolean equals(Plat p) {

        return (this.reference == p.getReference()) && (this.prix == p.getPrix()) && (this.nom.equals(p.getNom())) && (this.détail.equals(p.getDétail()));

    }
}
