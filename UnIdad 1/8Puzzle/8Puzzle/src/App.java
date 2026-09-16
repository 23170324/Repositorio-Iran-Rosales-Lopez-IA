public class App {
    public static void main(String[] args) throws Exception {
        String initialState = "7621 3458"; // Estado
        String goalState = "12345678 "; // Estado objetivo
        SearchTree searchTree = new SearchTree(initialState, goalState);
        //searchTree.breadthFirstSearch();
        searchTree.deepFirstSearch();
        //searchTree.UniformCostSearch();
        System.out.println("End");

        System.out.println("Initial State: " + initialState);
    }
}
