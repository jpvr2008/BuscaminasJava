public class CeldaSegura extends Celda {

    private int numeroMinasAlrededor;

    public void setNumeroMinasAlrededor(int n) {
        numeroMinasAlrededor = n;
    }

    @Override
    public int getMinas() {
        return numeroMinasAlrededor;
    }

    @Override
    public String render(boolean mostrarTodo) {
        if (estaMarcada() && !estaRevelada()) {
            return " F ";
        }
        if (!estaRevelada()) {
            return " . ";
        }
        if (numeroMinasAlrededor == 0) {
            return "   ";
        } else {
            return " " + numeroMinasAlrededor + " ";
        }
    }
}
