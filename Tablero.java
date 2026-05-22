
public class Tablero {

    private final int filas;
    private final int columnas;
    private final int totalMinas;
    private final Celda[][] cuadricula;

    public Tablero(int filas, int columnas, int totalMinas) {
        this.filas = filas;
        this.columnas = columnas;
        this.totalMinas = totalMinas;
        this.cuadricula = new Celda[filas][columnas];
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                cuadricula[f][c] = new CeldaSegura();
            }
        }
    }

    public Celda getCelda(int f, int c) {
        return cuadricula[f][c];
    }

    public void setCelda(int f, int c, Celda x) {
        cuadricula[f][c] = x;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getTotalMinas() {
        return totalMinas;
    }

    public boolean dentroDelTablero(int f, int c) {
        if (f >= 0 && f < filas && c >= 0 && c < columnas) {
            return true;
        }
        return false;
    }

}
