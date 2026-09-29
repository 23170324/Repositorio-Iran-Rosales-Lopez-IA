import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class SearchTree {
    Node root;
    String initialState;
    String goalState;

    public SearchTree(String initialState, String goalState) {
        this.initialState = initialState;
        this.goalState = goalState;
        this.root = new Node(initialState, null);
    }

    public void breadthFirstSearch() {
        int time = 0;
        //Crear estructura de datos para almacenar los nodos visitados
        Set<String> visited = new HashSet<String>();
        Node currentNode = root;
        //Buscart el nodo raiz y agregarlo a la cola
        Queue<Node> queue = new LinkedList<>();
        queue.add(currentNode);

        //Mientras la cola no esta vacia.
        while (!queue.isEmpty()) {
            time++;
            currentNode = queue.poll();
            visited.add(currentNode.getState());
            //System.out.println(NodeUtils.formatState(currentNode.getState()));
            if (currentNode.getState().equals(goalState)) {
               
                System.out.println("Goal state found: " + currentNode.getState());
                //Imprimir el camino desde la raiz hasta el nodo objetivo
                printPath(currentNode);
                break;
            }
            //Si no es el estado objetivo, generar los hijos y agregarlos a la cola
            List<Node> children = NodeUtils.generateChildren(currentNode);
            for (Node child : children) {
                if (!visited.contains(child.getState())) {
                    queue.add(child);
                }
            }
        }
            System.out.println("Tiempo: " + time);
            System.out.println("Estados visitados: " + visited.size());
            System.out.printf("Queue: %d%n", queue.size());
    }

        public void UniformCostSearch() {
        int time = 0;
        //Crear estructura de datos para almacenar los nodos visitados
        Set<String> visited = new HashSet<String>();
        Node currentNode = root;
        //Buscart el nodo raiz y agregarlo a la cola
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
        queue.add(currentNode);
        //Mientras la cola no esta vacia.
        while (!queue.isEmpty()) {
            time++;
            currentNode = queue.poll();
            visited.add(currentNode.getState());
            //System.out.println(NodeUtils.formatState(currentNode.getState()));
            if (currentNode.getState().equals(goalState)) {

                System.out.println("Goal state found: " + currentNode.getState());
                //Imprimir el camino desde la raiz hasta el nodo objetivo
                printPath(currentNode);
                   System.out.println("Tiempo: " + time);
                   System.out.println("Estados visitados: " + visited.size());
                         System.out.printf("Queue: %d%n", queue.size());
                return;
            }
            //Si no es el estado objetivo, generar los hijos y agregarlos a la cola
            List<Node> children = NodeUtils.generateChildren(currentNode);
            for (Node child : children) {
                if (!visited.contains(child.getState())) {
                    //Falto agregar la profunbdida del hijo antes de calcular el costo, 
                    // ya que el costo depende de la profundidad del nodo hijo
                    
                    child.setDepth(currentNode.getDepth() + 1);
                    child.setCost(currentNode.getCost() + 1);
                    queue.add(child);
                }
            }
        }

       
        System.out.println("Goal state not found");
        System.out.println("Tiempo: " + time);
        System.out.println("Estados visitados: " + visited.size());
        System.out.printf("Queue: %d%n", queue.size());
    }

     public void HeuristicaEjemplo() {
        int time = 0;
        //Crear estructura de datos para almacenar los nodos visitados
        Set<String> visited = new HashSet<String>();
        Node currentNode = root;
        //Buscart el nodo raiz y agregarlo a la cola
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
        queue.add(currentNode);
        //Mientras la cola no esta vacia.
        while (!queue.isEmpty()) {
            time++;
            currentNode = queue.poll();
            visited.add(currentNode.getState());
            //System.out.println(NodeUtils.formatState(currentNode.getState()));
            if (currentNode.getState().equals(goalState)) {

                System.out.println("Goal state found: " + currentNode.getState());
                //Imprimir el camino desde la raiz hasta el nodo objetivo
                printPath(currentNode);
                System.out.println("Goal state not found");
                   System.out.println("Tiempo: " + time);
                   System.out.println("Estados visitados: " + visited.size());
                         System.out.printf("Queue: %d%n", queue.size());
                return;
            }
            //Si no es el estado objetivo, generar los hijos y agregarlos a la cola
            List<Node> children = NodeUtils.generateChildren(currentNode);
            for (Node child : children) {
                if (!visited.contains(child.getState())) {
                    //Falto agregar la profunbdida del hijo antes de calcular el costo, 
                    // ya que el costo depende de la profundidad del nodo hijo
                    
                    child.setDepth(currentNode.getDepth() + 1);
                    int costoG = currentNode.getCost() + 1;
                    int costoH = Heuristica.evaluar(child.getState(), goalState);
                    child.setCost(costoG + costoH);
                    queue.add(child);
                }
            }
        }

       
        System.out.println("Goal state not found");
        System.out.println("Tiempo: " + time);
        System.out.println("Estados visitados: " + visited.size());
        System.out.printf("Queue: %d%n", queue.size());
    }

    public void deepFirstSearch() {
        int time=0;
        //Crear estructura de datos para almacenar los nodos visitados
        Set<String> visited = new HashSet<String>();
        Node currentNode = root;
        //Buscart el nodo raiz y agregarlo a la pila
        Stack<Node> stack = new Stack<>();
        stack.push(currentNode);

        //Mientras la pila no esta vacia.
        while (!stack.isEmpty()) {
             time++;
            currentNode = stack.pop();

            visited.add(currentNode.getState());
            //System.out.println(NodeUtils.formatState(currentNode.getState()));
            if (currentNode.getState().equals(goalState)) {
                
                System.out.println("Goal state found: " + currentNode.getState());
                //Imprimir el camino desde la raiz hasta el nodo objetivo
                printPath(currentNode);
                   System.out.println("Tiempo: " + time);
                   System.out.println("Estados visitados: " + visited.size());
                   System.out.printf("Stack: %d%n", stack.size());
                return;
            }
            //Si no es el estado objetivo, generar los hijos y agregarlos a la cola
            List<Node> children = NodeUtils.generateChildren(currentNode);
            for (Node child : children) {
                if (!visited.contains(child.getState())) {
                    stack.add(child);
                }
            }
        }
        System.out.println("Goal state not found");
        System.out.println("Tiempo: " + time);
        System.out.println("Estados visitados: " + visited.size());
        System.out.printf("Stack: %d%n", stack.size());

    }

    public void depthLimitedSearch(int limite) {
        int time = 0;
        Set<String> visited = new HashSet<String>();
        Node currentNode = root;
        // Buscar el nodo raíz y agregarlo a la pila
        Stack<Node> stack = new Stack<>();

        currentNode.setDepth(0); // Establecer la profundidad del nodo raíz
        stack.push(currentNode);
    
        // Mientras la pila no esté vacía
        while (!stack.isEmpty()) {
            time++;
            currentNode = stack.pop();

            // Verificar si es el estado objetivo
            if (currentNode.getState().equals(goalState)) {
                System.out.println("Goal state found: " + currentNode.getState());
                // Imprimir el camino desde la raíz hasta el nodo objetivo
                printPath(currentNode);
                System.out.println("Tiempo: " + time);
                System.out.println("Estados visitados: " + visited.size());
                System.out.printf("Stack: %d%n", stack.size());
                return;
            }

            if (currentNode.getDepth() >= limite) {
            continue; 
            }

            visited.add(currentNode.getState());

                List<Node> children = NodeUtils.generateChildren(currentNode);
                for (Node child : children) {
                    // Asignar profundidad al hijo antes de evaluarlo
                    child.setDepth(currentNode.getDepth() + 1);
                    
                    if (!visited.contains(child.getState())) {
                        stack.push(child);
                    }
                }
            
        }
        System.out.println("Goal state not found (o fuera del límite de profundidad)");
        System.out.println("Tiempo: " + time);
        System.out.println("Estados visitados: " + visited.size());
        System.out.printf("Stack: %d%n", stack.size());
    }

    public void iterativeDeepeningSearch() {
    for (int limite = 0; limite <= 50; limite++) {
        System.out.println("--- Ejecutando iteración con límite de profundidad: " + limite + " ---");

        Node resultado = depthLimitedSearchHelper(limite);

        if (resultado != null) {
            System.out.println("Goal state found: " + resultado.getState());
            printPath(resultado);
            return;
        }
    }
    System.out.println("Goal state not found");
}

// Método auxiliar para revisar un límite específico
private Node depthLimitedSearchHelper(int limite) {
    int time = 0;
    Set<String> visited = new HashSet<String>();
    Stack<Node> stack = new Stack<>();

    root.setDepth(0);
    stack.push(root);

    while (!stack.isEmpty()) {
        Node currentNode = stack.pop();
        time++;

        if (visited.contains(currentNode.getState())) {
            continue;
        }
        visited.add(currentNode.getState());

        if (currentNode.getState().equals(goalState)) {
            System.out.println("Tiempo: " + time);
            System.out.println("Estados visitados: " + visited.size());
            System.out.printf("Stack: %d%n", stack.size());
            return currentNode;
        }

        // Si ya llegó al límite de profundidad, no sigue expandiendo
        if (currentNode.getDepth() >= limite) {
            continue;
        }

        List<Node> children = NodeUtils.generateChildren(currentNode);
        for (Node child : children) {
            child.setDepth(currentNode.getDepth() + 1);

            if (!visited.contains(child.getState())) {
                stack.push(child);
            }
        }
    }
    System.out.println("Tiempo: " + time);
    System.out.println("Estados visitados: " + visited.size());
    System.out.printf("Stack: %d%n", stack.size());
    return null;
}

    private void printPath(Node node) {
        if (node == null) {
            return;
        }
        printPath(node.getParent());
        System.out.println(NodeUtils.formatState(node.getState()));
    }
}
