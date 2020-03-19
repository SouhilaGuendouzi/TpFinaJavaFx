package sample;

public class CommandeExiste extends Exception {
    @Override
    public String getMessage() {
        return "Cette commande existe  ";
    }
}
