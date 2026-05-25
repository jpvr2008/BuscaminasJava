
public class Calculador {

    private int contarMinasVecinas(Tablero t, int f, int c) {
        int contador = 0;
        for (int df = -1; df <= 1; df++) {
            for (int dc = -1; dc <= 1; dc++) {
                int nf = f + df, nc = c + dc;
                if (t.dentroDelTablero(nf, nc) && t.getCelda(nf, nc).esMina()) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public void calcularMinasVecinas(Tablero t) {
        int contador = 0;
        for (int f = 0; f < t.getFilas(); f++) {
            for (int c = 0; c < t.getColumnas(); c++) {
                if (!t.getCelda(f, c).esMina()) {
                    CeldaSegura celdaSegura = (CeldaSegura) t.getCelda(f, c);
                    int minasAlrededor = contarMinasVecinas(t, f, c);
                    celdaSegura.setNumeroMinasAlrededor(minasAlrededor);
                }
            }
        }
    }

}
