package sample;

import java.time.LocalDate;
import java.util.ArrayList;

public class Caisse {
    private ArrayList<Recette> recettes= new ArrayList<Recette>();

    // Getters & Setters
    public ArrayList<Recette> getRecettes() {
        return recettes;
    }

    public void setRecettes(ArrayList<Recette> recettes) {
        this.recettes = recettes;
    }

    // Constructeurs
    public Caisse(ArrayList<Recette> recettes) {
        this.recettes = recettes;
    }

    public Caisse() {
    }

    // Méthodes
    public double trouver_date(LocalDate date){           // une méthode qui retourne -1 si la date n'existe pas sinon il retourne la place du date dans la liste
        boolean trouver=false;
        double i=0;
        while(i<recettes.size() && !trouver ){
            if(recettes.get((int)i).getDate().equals(date)){
                trouver=true;
            }
            i++;
        }
        if (!trouver){ i=-1;}
        return i;
    }
}
