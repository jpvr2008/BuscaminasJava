public class ColocadorMinas {

    private final GeneradorNumeros generador = new GeneradorNumeros();

    private boolean esZonaSegura(int f, int c, int fs, int cs) {
        int df = f - fs;
        if (df < 0) {
            df = -df;
        }
        int dc = c - cs;
        if (dc < 0) {
            dc = -dc;
        }
        if (df <= 1 && dc <= 1) {
            return true;
        }
        return false;
    }

    public void colocarMinaEnPosicionRamdom(Tablero t, int filasegura, int columnaSegura) {
        int minasColocadas = 0;
        while (minasColocadas < t.getTotalMinas()) {
            int f = generador.siguiente(t.getFilas());
            int c = generador.siguiente(t.getColumnas());
            if (!t.getCelda(f, c).esMina() && !esZonaSegura(f, c, filasegura, columnaSegura)) {
                t.setCelda(f, c, new CeldaMina());
                minasColocadas++;
            }
        }
    }
}
