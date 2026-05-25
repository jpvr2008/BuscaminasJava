Explicación textual Buscaminas


Equipo de trabajo:


Juan Pablo Vega


Alejandro Beracierto


Simón Foguel







 El proyecto se hizo con 18 clases, las cuales son necesarias para que el juego funcione correctamente.
Para crear el programa usamos la POO, que quiere decir esto, dividimos el problema que era uno muy grande en ciertos subproblemas que son más sencillos de trabajar, las clases pueden cumplir tres funciones las cuales son primera guardar información, segunda ser el “cerebro” del programa (los cálculos) o tercera ser la parte visual del juego. Ahora vamos a explicar cada clase que función cumple.

1.	Modelo de datos: Las clases que guardan información
Para que nuestro buscaminas funcione primero se debe construir los cimientos donde se jugara. Son cinco las clases que funcionan como memoria del juego, ya que no toman ninguna decisión, si no que guardan el estado de las cosas en todo momento.
La primera clase es Celda, la cual es la unidad mas pequeña del juego, Celda solo sabe dos cosas de si misma, si el jugador ya la destapo o si el jugador le coloco una bandera, además celda tiene dos clases “hijas” las cuales son versiones mas especializadas de esta. Por un lado, esta CeldaSegura las cuales representan las celdas libres de peligro y además le indica al jugador cuantas minas tiene a su alrededor, por el otro Lado esta CeldaMina, cuya una misión es avisarle al sistema que tiene una bomba en el momento que el jugador decida cometer el error de destaparla.
La cuarta clase de este grupo es Tablero. Esta es la cuadricula del juego, esta crea un mapa bidimensional (filas y columnas) y contener todas las celdas, esto asegura que el sistema sepa donde empieza y donde termina el campo minado.
La ultima clase de este grupo es Partida. Esta clase lo que hace es que en el momento que termina la partida guarda toda la información (el tamaño del tablero, total de minas, tiempo de juego y si se ganó o se perdió para guardarla en el historial).
2.	El “cerebro” del juego la lógica y las reglas: Estas clases son aquellas que hacen el trabajo pesado. Estas clases no guardan información ni dibuja gráficos en la pantalla, estas clases son los motores que aplican las reglas matemáticas en el juego.
Primero tenemos a GeneradorNumeros, que funciona como un dado virtual, su función es lanzar coordenadas al azar para que cada partida sea única, ese dado es utilizado por la clase ColocadorMinas, que es el encargado de repartir las bombas por todo el mapa. Lo lindo de esta clase es que tiene una regla de supervivencia: siempre deja una zona libre de minas (un espacio de 3x3) alrededor del primer clic del usuario, para que este no pierda de manera injusta apenas empieza.
Después de que las minas están escondidas empieza a trabajar la clase Calculador la cual sirve como un escáner en todas las fichas vacías, a cada ficha le cuenta cuantas minas tiene a su alrededor y le asigna el numero que le sirve como pista al usuario.
Luego esta la clase Cascada, responsable de un efecto especial en el juego, si el usuario descubre una casilla totalmente vacía (un cero en Calculador), la clase lo que hace es desencadenar una reacción en cadena que destapa todas las casillas libres en un movimiento.
Por otro lado está la clase VerificadorFinalJuego, que su trabajo es estar revisando el tablero a ver si el jugador ya descubrió todas las celdas vacías y darle la victoria.
Por ultimo están para el control de datos las clases TiempoJugado, la cual funciona como un cronometro invisible que cuenta cuánto tiempo lleva jugando el usuario, y Historial, que recoge todas las estadísticas y las organiza como una tabla de posiciones, desde el más rápido al más lento, para que el jugador intente mejorar su mejor tiempo.
3.	La cara visible y el control: Para finalizar tenemos las clases que son las caras visibles del juego, estas son las clases que interactúan directamente con el jugador.
Empecemos con los “sentidos” del programa, la clase LectorDatos es nuestro escudo, lee todo lo que teclea el usuario, pero elimina los errores, evitando que el juego colapse si el jugador por error escribe una letra en vez de un número. La clase MenuConsola es el recepcionista del jugador, al cual pregunta cual dificultad quiere jugar o que tamaño del tablero quiere usar. Después de que el usuario decide entra en acción la clase DibujarTableroPantalla, que es el artista de las clases, toma toda la información invisible y la pinta en la consola usando símbolos, puntos y números para que el jugador pueda entender el campo minado.
Pero para que todo funcione se necesita un director, el cual es la clase EstadoPartida el cual hace que todo se mueva armónicamente, también está la clase JuegoConsola, el cual es el corazón absoluto del buscaminas. Contiene el bucle que mantiene el juego vivo, limpia la pantalla, le pide al usuario comandos, llama a las matemáticas para destapar las casillas y repite todo el proceso hasta que el jugador gana o pisa una mina.
Finalmente todo esto arranca con la clase Main, que es simplemente el botón de encendido del juego, su función es crear al juego e iniciarlo.



La conexión entre las clases se dan por cuatro tipos de relaciones: Herencia, composición,
agregación y dependencia/uso. La herencia en las clases CeldaSegura y CeldaMina, que son tiposde Celda; y en JuegoConsola, que hereda de EstadoPartida, ya que es lo más relevante
de cada partida en JuegoConsola. La relación de composición se usó para todas las clases
cuyos métodos creaban nuevos objetos de otras clases, es decir, que instanciaban estos
métodos en sus atributos. Por ejemplo, tablero crea las celdas que lo componen desde su constructor y juegoConsola crea todas las clases que interfieren como atributos. La agregación  se usó en Historial y Partida, ya que las partidas pueden existir sin el historial; solo se pasan a este para el almacenamiento. Y en cuanto a dependencia/uso, cuando una clase  necesitaba a otra, pero sin poseerla ni crearla. Por ejemplo Cascada, Calculador, ColocadorMinas y VerificadorFinal usan a tablero como parámetro en sus métodos, lo usan y luego lo olvidan.



Para el tablero se eligió un tablero bidimensional el cual es estático, se usó Celda[][] y no ArrayList porque el tablero debe tener unas dimensiones fijas desde el momento en que se crea el tablero nunca va a aumentar ni a disminuir su tamaño, por eso es más simple y eficiente usar un arreglo estático, por que con este es más sencillo acceder a una celda basándonos en coordenadas, que con ArrayList, que además de que el tablero no tiene la necesidad de cambiar su tamaño es más difícil invocar una celda. El ArrayList si nos fue útil en la clase Historial por que el número de partidas que se pueden llegar a jugar son indeterminados desde el comienzo



El juego comienza en Main. Se crea el objeto JuegoConsola de tipo EstadoPartida, gracias a el polimorfismo. Se llama al método IniciarPartida en JuegoConsola y, posteriormente, se muestra el menú principal (MenuConsola). Al darle a la opción 1, el usuario elige la dificultad y se crea el tablero, compuesto de CeldaSegura. Inicia Bucle y empieza el juego, el jugador hace su primera jugada y se ponen las minas, posteriormente se le hace una llamada constante a Cascada, que activa el método revelar y descubre todas las celdas alrededor de la elegida si cumplen con la condición de ser CeldaSegura; con la ayuda de  procesarComando y AccionDescubrir se dan uso a los comandos que revelan cada celda en el tablero y sus comportamientos. El juego termina con la partida guardada gracias a MostrarFin, que hace uso de verificarFinal, se almacena en Historial y se le indica al usuario si perdió o no; todo dependiendo de las decisiones tomadas y ejecutadas durante la partida.



Al separar el almacenamiento de datos, la lógica  y la interfaz visual, logramos obtener un código ordenado fácil de leer y perfectamente preparado para seguir creciendo y mejorando en un futuro.



Diagrama de clases:
![Diagrama UML](BuscaminasUML.pdf)