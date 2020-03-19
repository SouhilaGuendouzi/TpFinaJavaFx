package sample;

public class PlatIntrouvable extends Exception {
    @Override
    public String getMessage() {
        return "Ce plat n'existe pas ";
    }
}
