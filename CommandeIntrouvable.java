package sample;

public class CommandeIntrouvable extends Exception {
    @Override
    public String getMessage() {
        return "Cette Commande n'existe pas  ";
    }
}
