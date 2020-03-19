package sample;

public class ListPlatsVide extends Exception {
    @Override
    public String getMessage() {
        return "La liste Des plats est vide ";
    }
}
