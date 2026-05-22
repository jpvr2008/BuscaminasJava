import java.util.Random;

public class GeneradorNumeros {

    private final Random numeroRandom = new Random();

    public int siguiente(int max) {
        return numeroRandom.nextInt(max);
    }

}
