
public class Cascada {

    public void relevar(Tablero t, int f, int c) {
        if (!t.dentroDelTablero(f, c)) {
            return;
        }
        Celda celda = t.getCelda(f, c);
        if (celda.estaMarcada() || celda.estaRevelada() || celda.esMina()) {
            return;
        }
        celda.revelar();
        if (celda.getMinas() == 0) {
            for (int df = -1; df <= 1; df++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (df != 0 || dc != 0) {
                        int filaVecino = f + df;
                        int columnaVecina = c + dc;
                        relevar(t, filaVecino, columnaVecina);
                    }
                }
            }
        }
    }
}
