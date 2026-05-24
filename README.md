Cómo compilar y ejecutar
Abre una terminal en la carpeta del proyecto
Compila:
javac *.java

Ejecuta:
java Main

Comandos del juego

D fila columna → Descubrir una casilla. Ejemplo: D 3 5
M fila columna → Poner o quitar bandera. Ejemplo: M 2 4
S → Salir de la partida

Dificultades disponibles

Fácil: 9x9 con 10 minas
Medio: 16x16 con 40 minas
Difícil: 16x30 con 99 minas
Personalizado: el jugador define las dimensiones y minas


El proyecto tiene 18 clases organizadas por responsabilidad:

Celda, CeldaMina, CeldaSegura     → las casillas del tablero
Tablero                            → la cuadrícula del juego
ColocadorMinas, Calculador         → lógica de minas y números
Cascada, VerificadorFinalJuego     → revelación y detección de victoria
GeneradorNumeros, TiempoJugado     → utilidades
LectorDatos, DibujarTableroPantalla, MenuConsola  → interfaz de consola
Partida, Historial                 → registro de partidas
EstadoPartida, JuegoConsola, Main  → orquestación del juego
