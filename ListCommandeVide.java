package sample;

public class ListCommandeVide extends Exception {
    @Override
    public String getMessage() {
        return "Aucune Commande trouvée ";
    }
}
