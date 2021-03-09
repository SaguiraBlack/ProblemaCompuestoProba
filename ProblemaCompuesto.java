/** TOVAR ESPEJO M. JOSEFINA | ESCOM | PROBABILIDAD Y ESTADÍSTICA 2CV18 **/
/* Importación de bibliotecas */
import java.util.Scanner;

/* Clase del Problema Compuesto */
public class ProblemaCompuesto {
    /* Inicializando variables a usar */
    Scanner lector = new Scanner(System.in);
    private int cantidadProblemasSimples;
    private ProblemaSimple[] problemasSimples;
    private int cantidadCombinaciones;
    private String[][] combinaciones;
    private int[] indices;

    /* Función para pedir el número de problemas simples a ingresar */
    public void pedirProblemasSimples() {
        System.out.println("¿Cuantos problemas simples hay?");
        cantidadProblemasSimples = lector.nextInt();
        lector.nextLine();
        /* Se inicializa el arreglo con el tamaño de la cantidad de problemas simples */
        problemasSimples = new ProblemaSimple[cantidadProblemasSimples];
        for(int i = 0; i < cantidadProblemasSimples; i++) {
            System.out.println("Ingresando problema simple " + (i+1));
            /* Se agrega un nuevo objeto */
            problemasSimples[i] = new ProblemaSimple();
        }
        /* Arreglo de indices auxiliares para mostrar las combinaciones posibles */
        indices = new int[cantidadProblemasSimples];
    }

    /* Función que calcula la cantidad de resultados posibles */
    public void imprimirResultadosTotales() {
        for(int i = 0; i < cantidadProblemasSimples; i++) {
            problemasSimples[i].imprimirResultados(i);
        }
    }

    /* Funcióm que calcula cuáles son las combinaciones posibles */
    public void calcularCombinaciones() {
        cantidadCombinaciones = 1;
        for(int i = 0; i < cantidadProblemasSimples; i++) {
            cantidadCombinaciones = cantidadCombinaciones * problemasSimples[i].getCantidadResultados();
        }
        System.out.println("La cantidad de combinaciones posibles es: " + cantidadCombinaciones);
        /* Se utiliza un arreglo bidimensional */
        combinaciones = new String[cantidadCombinaciones][cantidadProblemasSimples];
        for(int j = 0; j < cantidadCombinaciones; j++) {
            for(int k = 0; k < cantidadProblemasSimples; k++) {
                combinaciones[j][k] = problemasSimples[k].getNombresResultados()[indices[k]];
            }
            /* Esto corresponde a los índices auxiliares */
            aumentarIndice(cantidadProblemasSimples-1);
        }
    }

    /* Función que imprime las combinaciones posibles, guardadas en el arreglo */
    public void imprimirCombinaciones() {
        for (int x = 0; x < combinaciones.length; x++) {
            System.out.print("[");
            for (int y = 0; y < combinaciones[x].length; y++) {
              System.out.print (combinaciones[x][y]);
              if (y != combinaciones[x].length-1) System.out.print("\t");
            }
            System.out.println("]");
          }
    }

    /* Función que aumenta el índice del arreglo auxiliar */
    public void aumentarIndice(int k) {
        if (k < 0) return;
        if(indices[k] >= problemasSimples[k].getCantidadResultados()-1) {
            indices[k] = 0;
            aumentarIndice(k-1);
        }
        else {
            indices[k] += 1;
        }
    }

    /* Constructor de la clase */
    public ProblemaCompuesto() {
        pedirProblemasSimples();
    }
}
