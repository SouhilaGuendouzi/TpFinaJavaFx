package sample;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;

public class Commande implements Serializable  {
    private int code;
    private int num_table;
    private LocalDate date = LocalDate.now();
    private LocalTime heure = LocalTime.now();
    private double total;
    private String mode_paiement;
    private boolean id_cloture=false;
    private ArrayList<Ligne> lignes_commande= new ArrayList<Ligne>();
    static int id=0;

    // Getters & Setters

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getNum_table() {
        return num_table;
    }

    public void setNum_table(int num_table) {
        this.num_table = num_table;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMode_paiement() {
        return mode_paiement;
    }

    public void setMode_paiement(String mode_paiement) {
        this.mode_paiement = mode_paiement;
    }

    public boolean isId_cloture() {
        return id_cloture;
    }

    public void setId_cloture(boolean id_cloture) {
        this.id_cloture = id_cloture;
    }

    public ArrayList<Ligne> getLignes_commande() {
        return lignes_commande;
    }

    public void setLignes_commande(ArrayList<Ligne> lignes_commande) {
        this.lignes_commande = lignes_commande;
    }

    //Constructeurs

    public Commande(int num_table, String mode_paiement, ArrayList<Ligne> lignes_commande) {

        this.num_table = num_table;
        this.mode_paiement = mode_paiement;
        this.lignes_commande = lignes_commande;
        this.total =0;
        this.code=id;
        id++;
    }
    public Commande(){

        this.code=id;
        id++;
    }

    // Méthodes

    @Override
    public String toString() {
        return "Commande{" +
                "code=" + code +
                ", num_table=" + num_table +
                ", date=" + date +
                ", heure=" + heure +
                ", total=" + total +
                ", mode_paiement='" + mode_paiement + '\'' +
                ", id_cloture=" + id_cloture +
                ", lignes_commande=" + lignes_commande.toString() +
                '}';
    }

    public double total(){
        double x=0;
        for (int i=0; i<this.lignes_commande.size();i++){
            x=x+this.lignes_commande.get(i).getPlat().prix*this.lignes_commande.get(i).getQuantité();
        }

        return x;
    }
    public boolean equals(Commande c) {
        if (this.lignes_commande.size()!=c.lignes_commande.size()) return false;
        else {
            boolean b = (this.mode_paiement.equals(c.mode_paiement)) && (this.id_cloture == c.id_cloture) && (this.code == c.code) && (this.date.equals(c.date)) && (this.total == c.total) && (this.num_table== c.num_table) && (this.heure.equals(c.heure));
            boolean d =true;
            int i=0;
            while((d==true)&&(i<this.lignes_commande.size()))
            {
                int j=0;
                boolean e=true;
                while((e==true)&&(j<c.lignes_commande.size()))
                {
                    if (this.lignes_commande.get(i).equal(c.lignes_commande.get(j))) e=false ;j++;
                }
                if (e==true) d=false;i++;

            }
            return d&&b;
        }
    }


}


