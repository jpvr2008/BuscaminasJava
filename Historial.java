import java.util.ArrayList;

public class Historial {

    private ArrayList<Partida> partidas = new ArrayList<>();

    public void agregar(Partida p) {
        partidas.add(p);
    }

    public void mostrar() {
        if (partidas.isEmpty()) {
            System.out.println("No hay partidas registradas.");
            return;
        }
        ordenarPorTiempo();
        for (int i = 0; i < partidas.size(); i++) {
            Partida p = partidas.get(i);
            System.out.println((i + 1) + ". " + p.getDificultad()
                    + " | " + p.getFilas() + "x" + p.getColumnas()
                    + " | Minas: " + p.getMinas()
                    + " | Tiempo: " + p.getTiempo() + "s"
                    + " | " + (p.getGano() ? "GANO" : "PERDIO"));
        }
    }

    public void ordenarPorTiempo() {
        for (int i = 0; i < partidas.size() - 1; i++) {
            for (int j = 0; j < partidas.size() - 1 - i; j++) {
                if (partidas.get(j).getTiempo() > partidas.get(j + 1).getTiempo()) {
                    Partida temp = partidas.get(j);
                    partidas.set(j, partidas.get(j + 1));
                    partidas.set(j + 1, temp);
                }
            }
        }
    }

    public int buscarPorTiempo(long tiempo) {
        ordenarPorTiempo();
        int inicio = 0;
        int fin = partidas.size() - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (partidas.get(medio).getTiempo() == tiempo) {
                return medio;
            } else if (partidas.get(medio).getTiempo() < tiempo) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    public int getTamanio() {
        return partidas.size();
    }
}
