public class Arbol {
    private Nodo raiz;

    public boolean vacio() {
        return raiz == null;
    }

    public void insertar(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("El nombre no puede ser null.");
        }

        raiz = insertar(raiz, nombre);
    }

    private Nodo insertar(Nodo actual, String nombre) {
        if (actual == null) {
            return new Nodo(nombre);
        }

        int comparacion = nombre.compareToIgnoreCase(actual.getNombre());
        if (comparacion < 0) {
            actual.setIzquierdo(insertar(actual.getIzquierdo(), nombre));
        } else if (comparacion > 0) {
            actual.setDerecho(insertar(actual.getDerecho(), nombre));
        }

        return actual;
    }

    public Nodo buscarNodo(String nombre) {
        if (nombre == null) {
            return null;
        }

        Nodo actual = raiz;
        while (actual != null) {
            int comparacion = nombre.compareToIgnoreCase(actual.getNombre());
            if (comparacion == 0) {
                return actual;
            }

            actual = comparacion < 0 ? actual.getIzquierdo() : actual.getDerecho();
        }

        return null;
    }
}