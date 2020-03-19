package sample;

import java.time.LocalDate;
import java.util.ArrayList;



public class Recette {
    private LocalDate date;
    private ArrayList<Commande> commandes= new ArrayList<Commande>();

    // Getters & Setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ArrayList<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(ArrayList<Commande> commandes) {
        this.commandes = commandes;
    }

    // Constructeurs
    public Recette( ArrayList<Commande> commandes) {
        this.commandes = commandes;
    }

    public Recette() {
    }

    // Méthodes


    @Override
    public String toString() {
        return "Recette{" +
                "date=" + date +
                ", commandes=" + commandes +
                '}';
    }


}
