
public class TiempoJugado {

    private long inicio;

    public void iniciar() {
        inicio = System.currentTimeMillis();
    }

    public long segundos() {
        return ((System.currentTimeMillis() - inicio) / 1000);
    }
}
