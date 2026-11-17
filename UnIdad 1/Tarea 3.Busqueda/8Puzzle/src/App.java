import java.util.List;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        String initialState = "7621 3458"; // Estado
        String goalState = "12345678 "; // Estado objetivo
        SearchTree searchTree = new SearchTree(initialState, goalState);
        //searchTree.breadthFirstSearch();
        //searchTree.deepFirstSearch();
        //searchTree.UniformCostSearch();
        searchTree.depthLimitedSearch(60); // Límite de profundidad de 10
        //searchTree.iterativeDeepeningSearch();
        System.out.println("End");

        System.out.println("Initial State: " + initialState);

        List<Node> children = NodeUtils.generateChildren(new Node("7621 3458", null)); // Example usage of generateChildren method
        for (Node child : children) {
            System.out.println("Child state: " + child.getState());
        }
        

        /* 
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
        Node n1 = new Node("n1", null);
        n1.setCost(5);

        Node n2 = new Node("n2", null);
        n2.setCost(3);

        Node n3 = new Node("n3", null);
        n3.setCost(7);

        Node n4 = new Node("n4", null);
        n4.setCost(2);

        queue.add(n1); // 5
        queue.add(n2); // 3
        queue.add(n3); // 7
        queue.add(n4); // 2

        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.getState() + " - Cost: " + node.getCost());
        }
        */
    }
}
