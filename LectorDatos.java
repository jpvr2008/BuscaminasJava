
import java.util.Scanner;

public class LectorDatos {

    private final Scanner sc = new Scanner(System.in);

    public String leerLinea() {
        return sc.nextLine().trim();
    }

    public int leerInt(int min, int max) {
        int v = 0;
        boolean valido = false;
        while (!valido) {
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) {
                System.out.print("Error, ingrese un número entre " + min + " y " + max + ": ");
                continue;
            }
            boolean esNumero = true;
            for (int i = 0; i < linea.length(); i++) {
                if (!Character.isDigit(linea.charAt(i))) {
                    esNumero = false;
                    break;
                }
            }
            if (!esNumero) {
                System.out.print("Error, lo que ingresó es incorrecto. Ingrese entre " + min + " y " + max + ": ");
                continue;
            }
            v = Integer.parseInt(linea);
            if (v >= min && v <= max) {
                valido = true;
            } else {
                System.out.print("Error, lo que ingresó es incorrecto. Ingrese entre " + min + " y " + max + ": ");
            }
        }
        return v;
    }

}
