
public class Celda {

    private boolean revelada;
    private boolean marcada;

    public boolean estaRevelada() {
        return revelada;
    }

    public boolean estaMarcada() {
        return marcada;
    }

    public boolean esMina() {
        return false;
    }

    public int getMinas() {
        return 0;
    }

    public void revelar() {
        revelada = true;
    }

    public void cambiarEstadoMarcada() {
        marcada = !marcada;
    }

    public String render(boolean mostrarTodo) {
        if (!revelada && marcada) {
            return " B ";
        }
        if (!revelada) {
            return " . ";
        }
        return "   ";
    }

}
