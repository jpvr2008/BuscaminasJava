
public class JuegoConsola extends EstadoPartida {

    private final LectorDatos lector = new LectorDatos();
    private final DibujarTableroPantalla dibujante = new DibujarTableroPantalla();
    private final ColocadorMinas colocador = new ColocadorMinas();
    private final Calculador calculador = new Calculador();
    private final Cascada cascada = new Cascada();
    private boolean minasListas;
    private final Historial historial = new Historial();

    public void esperar(String mensaje) {
        System.out.println(mensaje);
        long inicio = System.currentTimeMillis();
        while (System.currentTimeMillis() - inicio < 2000) {
        }
    }

    public void accionDescubrir(int f, int c) {
        if (!minasListas) {
            colocador.colocarMinaEnPosicionRamdom(tablero, f, c);
            calculador.calcularMinasVecinas(tablero);
            minasListas = true;
        }
        Celda celda = tablero.getCelda(f, c);
        if (celda.estaMarcada() || celda.estaRevelada()) {
            return;
        }
        if (celda.esMina()) {
            celda.revelar();
            terminado = true;
            return;
        }
        cascada.relevar(tablero, f, c);
        if (verificarFinal.hayVictoria(tablero)) {
            terminado = true;
            gano = true;
        }
    }

    public void procesarComando(String linea) {
        if (linea.equals("S")) {
            terminado = true;
            return;
        }
        String[] partes = linea.split("\\s+");
        if (partes.length != 3) {
            esperar("Comando inválido. Ej: D 3 5");
            return;
        }
        int f, c;
        f = Integer.parseInt(partes[1]) - 1;
        c = Integer.parseInt(partes[2]) - 1;
        if (!tablero.dentroDelTablero(f, c)) {
            esperar("Fuera del tablero. Indique una posición válida");
            return;
        }
        if (partes[0].equals("D")) {
            accionDescubrir(f, c);
        } else if (partes[0].equals("M")) {
            tablero.getCelda(f, c).cambiarEstadoMarcada();
        } else {
            esperar("Usa D o M para jugar.");
        }
    }

    public void mostrarFin() {
        dibujante.limpiarTablero();
        dibujante.dibujar(tablero, true);
        String dificultad;
        if (tablero.getFilas() == 9 && tablero.getColumnas() == 9) {
            dificultad = "Facil";
        } else if (tablero.getFilas() == 16 && tablero.getColumnas() == 16) {
            dificultad = "Medio";
        } else if (tablero.getFilas() == 16 && tablero.getColumnas() == 30) {
            dificultad = "Dificil";
        } else {
            dificultad = "Personalizado";
        }
        Partida partida = new Partida(dificultad, tablero.getFilas(), tablero.getColumnas(), tablero.getTotalMinas(), reloj.segundos(), gano);
        historial.agregar(partida);
        if (gano) {
            System.out.println("Ganaste en: " + reloj.segundos() + "s");
        } else {
            System.out.println("Perdiste");
        }
    }

    public void bucle() {
        while (!terminado) {
            dibujante.limpiarTablero();
            dibujante.dibujar(tablero, false);
            System.out.println("Minas: " + (tablero.getTotalMinas() - verificarFinal.contarBanderas(tablero)) + "| " + "Tiempo :" + reloj.segundos() + "s");
            System.out.println(" D fila Columna = Descubrir | M fila columna = Marcar Bandera  | S= Salir");
            System.out.print(">>>");
            procesarComando(lector.leerLinea().toUpperCase());
        }
        mostrarFin();
    }

    @Override
    public void iniciarPartida() {
        boolean seguirJugando = true;
        while (seguirJugando) {
            dibujante.limpiarTablero();
            MenuConsola menu = new MenuConsola(lector);
            int opcion = menu.mostrarMenuPrincipal();
            if (opcion == 2) {
                historial.mostrar();
                System.out.print("Buscar partida por tiempo en segundos (Enter para omitir): ");
                String busqueda = lector.leerLinea();
                if (!busqueda.isEmpty()) {
                    long tiempo = Long.parseLong(busqueda);
                    int resultado = historial.buscarPorTiempo(tiempo);
                    if (resultado == -1) {
                        System.out.println("No se encontró ninguna partida con ese tiempo.");
                    } else {
                        System.out.println("Partida encontrada en posición: " + (resultado + 1));
                    }
                }
                System.out.print("Presiona Enter para continuar...");
                lector.leerLinea();
            } else {
                tablero = menu.elegirTablero();
                terminado = false;
                gano = false;
                minasListas = false;
                reloj.iniciar();
                bucle();
                System.out.print("Presiona Enter para continuar...");
                lector.leerLinea();
            }
        }
    }
}
