package sample;

import java.io.Serializable;

public class Ligne implements Serializable , Cloneable {
    private Plat plat;
    private int quantité;

    // Getters & Setters
    public Plat getPlat() {
        return plat;
    }

    public void setPlat(Plat plat) {
        this.plat = plat;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    // Constructeurs
    public Ligne(Plat plat, int quantité) {
        this.plat = plat;
        this.quantité = quantité;
    }
    public Ligne(){

    }

    @Override
    public String toString() {
        return
                "plat=>" + plat +"\t"+
                "quantité=" + quantité +"\n";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Ligne l=null;
        l.quantité=this.quantité;
        l.plat=this.plat;
        return l;

    }

    public boolean equal(Ligne l)
    {
        return (this.plat.equals(l.getPlat()))&&(this.quantité==l.getQuantité());
    }
}