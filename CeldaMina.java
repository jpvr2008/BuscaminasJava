public class CeldaMina extends Celda {

    @Override
    public boolean esMina() {
        return true;
    }

    @Override
    public String render(boolean mostrarTodo) {
        if (estaMarcada() && !estaRevelada()) {
            return " F ";
        }
        if (!estaRevelada()) {
            if (mostrarTodo) {
                return " X ";
            } else {
                return " . ";
            }
        }
        return " * ";
    }
}
