public class VerificadorFinalJuego {

    public boolean hayVictoria(Tablero t) {
        for (int f = 0; f < t.getFilas(); f++) {
            for (int c = 0; c < t.getColumnas(); c++) {
                if (!t.getCelda(f, c).esMina() && !t.getCelda(f, c).estaRevelada()) {
                    return false;
                }
            }
        }
        return true;
    }

    public int contarBanderas(Tablero t) {
        int n = 0;
        for (int f = 0; f < t.getFilas(); f++) {
            for (int c = 0; c < t.getColumnas(); c++) {
                if (t.getCelda(f, c).estaMarcada()) {
                    n++;
                }
            }
        }
        return n;
    }
}
