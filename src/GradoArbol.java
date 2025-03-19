//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

class Nodo {
    String valor;
    List<Nodo> hijos;

    public Nodo(String valor) {
        this.valor = valor;
        this.hijos = new ArrayList<>();
    }
}

public class GradoArbol {
    public static int calcularGrado(Nodo raiz) {
        if (raiz == null) return 0;  // Si el árbol está vacío, el grado es 0

        int maxGrado = 0;
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            Nodo nodo = cola.poll();
            int numHijos = nodo.hijos.size();

            // Comparación sin Math.max
            if (numHijos > maxGrado) {
                maxGrado = numHijos;
            }

            cola.addAll(nodo.hijos); // Agregar los hijos del nodo a la cola
        }

        return maxGrado;
    }

    public static void main(String[] args) {
        // 📌 Crear nodos
        Nodo A = new Nodo("A");
        Nodo B = new Nodo("B");
        Nodo C = new Nodo("C");
        Nodo D = new Nodo("D");
        Nodo E = new Nodo("E");
        Nodo F = new Nodo("F");
        Nodo G = new Nodo("G");

        // Construir el árbol con grado 2
        A.hijos.add(B);
        A.hijos.add(C);
        B.hijos.add(D);
        B.hijos.add(E);
        C.hijos.add(F);
        C.hijos.add(G);

        System.out.println("Grado del árbol: " + calcularGrado(A)); // Salida esperada: 2
    }
}
