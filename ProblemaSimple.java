/** TOVAR ESPEJO M. JOSEFINA | ESCOM | PROBABILIDAD Y ESTADÍSTICA 2CV18 **/
/* Importación de bibliotecas */
import java.util.Scanner;

/* Clase del Problema Simple */
public class ProblemaSimple {
    /* Inicializando variables a usar */
    Scanner lector = new Scanner(System.in);
    private int cantidadResultados;
    private String[] nombresResultados;

    /* Método que pide los resultados de cada problema simple */
    public void pedirResultados() {
        System.out.println("¿Cuantos resultados tiene el problema simple?");
        cantidadResultados = lector.nextInt();
        lector.nextLine();
        nombresResultados = new String[cantidadResultados];
        for(int i = 0; i < cantidadResultados; i++) {
            System.out.println("Ingresa el resultado " + (i+1));
            nombresResultados[i] = lector.nextLine();
        }
    }

    /* Método que imprime la cantidad de resultados de cada problema simple */
    public void imprimirResultados(int numeroProblema) {
        System.out.println("Los resultados del problema simple " + (numeroProblema+1) + " son: " + cantidadResultados);
    }

    /* Método para obtener el nombre del resultado */
    public String[] getNombresResultados() {
        return nombresResultados;
    }

    /* Método para obtener la cantidad de resultados */
    public int getCantidadResultados() {
        return cantidadResultados;
    }

    /* Constructor de ProblemaSimple */
    public ProblemaSimple() {
        pedirResultados();
    }
}