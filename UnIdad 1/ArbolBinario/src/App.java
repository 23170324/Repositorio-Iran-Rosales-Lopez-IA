public class App {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        arbol.insertar("Marta");
        arbol.insertar("Carlos");
        arbol.insertar("Sofia");
        arbol.insertar("Ana");

        System.out.println("¿El árbol está vacío? " + arbol.vacio());

        Nodo encontrado = arbol.buscarNodo("Carlos");
        if (encontrado != null) {
            System.out.println("Nodo encontrado: " + encontrado.getNombre());
        } else {
            System.out.println("El nombre no está en el árbol.");
        }
    }
}
