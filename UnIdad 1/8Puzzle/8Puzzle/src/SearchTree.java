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
        this.root = new Node(initialState, null, 0);
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
                   System.out.println("Goal state not found");
                   System.out.println("Tiempo: " + time);
                   System.out.println("Estados visitados: " + visited.size());
                return;
            }
            //Si no es el estado objetivo, generar los hijos y agregarlos a la cola
            List<Node> children = NodeUtils.generateChildren(currentNode);
            for (Node child : children) {
                if (!visited.contains(child.getState())) {
                    queue.add(child);
                }
            }
        }

       
        System.out.println("Goal state not found");
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
                System.out.println("Goal state not found");
                   System.out.println("Tiempo: " + time);
                   System.out.println("Estados visitados: " + visited.size());
                return;
            }
            //Si no es el estado objetivo, generar los hijos y agregarlos a la cola
            List<Node> children = NodeUtils.generateChildren(currentNode);
            for (Node child : children) {
                if (!visited.contains(child.getState())) {
                    //Falto agregar la profunbdida
                    child.setDepth(currentNode.getDepth() + 1);
                    child.setCost(child.getDepth());
                    queue.add(child);
                }
            }
        }

       
        System.out.println("Goal state not found");
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
                   System.out.println("Goal state not found");
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

    }
    private void printPath(Node node) {
        if (node == null) {
            return;
        }
        printPath(node.getParent());
        System.out.println(NodeUtils.formatState(node.getState()));
    }
}
