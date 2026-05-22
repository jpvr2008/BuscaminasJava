public class Partida {

    private String dificultad;
    private int filas;
    private int columnas;
    private int minas;
    private long tiempo;
    private boolean gano;

    public Partida(String dificultad, int filas, int columnas, int minas, long tiempo, boolean gano) {
        this.dificultad = dificultad;
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        this.tiempo = tiempo;
        this.gano = gano;
    }

    public String getDificultad() {
        return dificultad;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getMinas() {
        return minas;
    }

    public long getTiempo() {
        return tiempo;
    }

    public boolean getGano() {
        return gano;
    }
}
