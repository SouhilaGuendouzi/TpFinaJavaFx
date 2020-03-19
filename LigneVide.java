package sample;

public class LigneVide extends Exception {
    @Override
    public String getMessage() {
        return "L'ajout de la commande est impossible ,Veuillez remplir votre commande";
    }
}
