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
     * Adding child to this node
     *
     * If there are no children yet, it will also
     * create a new instance of a LinkedList.
     *
     * @param node Child node
     */
    public void addChild(Node node) {
        if (this.children == null){
            this.children = new LinkedList<>();
        }
        this.children.add(node);
    }

    @Override
    public String toString() {
        return "" + this.value;
    }
}