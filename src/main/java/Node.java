import java.util.LinkedList;
import java.util.List;

public class Node {
    public int value;
    public List<Node> children;

    /**
     * Constructor
     *
     * @param value Node value
     */
    public Node(int value) {
        this.value = value;
    }

    /**
     * Adding child to node
     *
     * @param node Child node
     */
    public void addChild(Node node) {
        // If children is empty, we first create the LinkedList
        if (this.children == null){
            this.children = new LinkedList<Node>();
        }
        this.children.add(node);
    }

    @Override
    public String toString() {
        return "" + this.value;
    }
}