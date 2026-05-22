
public class MenuConsola {

    private final LectorDatos lector;
    private final DibujarTableroPantalla dibujante = new DibujarTableroPantalla();

    public MenuConsola(LectorDatos lector) {
        this.lector = lector;
    }

    public int mostrarMenuPrincipal() {
        System.out.println("__________Buscaminas__________");
        System.out.println("1. Jugar");
        System.out.println("2. Ver historial de partidas");
        System.out.print("Opcion: ");
        return lector.leerInt(1, 2);
    }

    public Tablero pedirPersonalizado() {
        dibujante.limpiarTablero();
        System.out.println("Ingrese el número de filas (5-30): ");
        int filas = lector.leerInt(5, 30);
        System.out.println("Ingrese las columnas (5-40): ");
        int columnas = lector.leerInt(5, 40);
        int minasMaximas = (filas * columnas) - 9;
        System.out.println("Ingrese el número de minas: ");
        int minas = lector.leerInt(1, minasMaximas);
        return new Tablero(filas, columnas, minas);
    }

    public Tablero elegirTablero() {
        dibujante.limpiarTablero();
        System.out.println("__________Selecciona el modo de juego__________");
        System.out.println("Modalidades de juego:");
        System.out.println("1. Facil: 9x9 10 minas.");
        System.out.println("2. Medio 16x16 40 minas.");
        System.out.println("3. Dificil 16x30 99 minas");
        System.out.println("4. Personalizado.");
        int opcion = lector.leerInt(1, 4);
        if (opcion == 1) {
            return new Tablero(9, 9, 10);
        } else if (opcion == 2) {
            return new Tablero(16, 16, 40);
        } else if (opcion == 3) {
            return new Tablero(16, 30, 99);
        } else {
            return pedirPersonalizado();
        }
    }
}
