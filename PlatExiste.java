package sample;

public class PlatExiste extends Exception {
    @Override
    public String getMessage() {
        return "Ce plat existe ";
    }
}
