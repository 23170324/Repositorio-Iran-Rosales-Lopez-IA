public class Nodo {
    private final String nombre;
    private Nodo izquierdo;
    private Nodo derecho;

    public Nodo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
}