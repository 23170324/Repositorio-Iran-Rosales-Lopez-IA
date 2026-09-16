
public class Node {
    // Todo privado
    private String state;
    private Node parent;
    private int depth;
    private int cost;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Node(String state, Node parent, int depth) {
        this.state = state;
        this.parent = parent;
        this.depth = depth;
    }

    // Getters y Setters necesarios
    public String getState() {
        return state;
    }

    void setState(String state) {
        this.state = state;
    }

    public Node getParent() {
        return parent;
    }

    void setParent(Node parent) {
        this.parent = parent;
    }

    public int getDepth() {
        return depth;
    }

    void setDepth(int depth) {
        this.depth = depth;
    }
}