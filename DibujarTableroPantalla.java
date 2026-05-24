
public class DibujarTableroPantalla {

    public void dibujar(Tablero t, boolean mostrarTodo) {
        System.out.print("    ");
        for (int c = 0; c < t.getColumnas(); c++) {
            System.out.printf("%3d", c + 1);
        }
        System.out.println();
        System.out.print("    ");
        for (int c = 0; c < t.getColumnas(); c++) {
            System.out.print("---");
        }
        System.out.println();
        for (int f = 0; f < t.getFilas(); f++) {
            System.out.printf("%3d| ", f + 1);
            for (int c = 0; c < t.getColumnas(); c++) {
                String textoCelda = t.getCelda(f, c).render(mostrarTodo);
                System.out.print(textoCelda);
            }
            System.out.println();
        }
    }

    public void limpiarTablero() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
