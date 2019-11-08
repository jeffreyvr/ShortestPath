import java.util.List;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;

public class ShortestPath {
    /**
     * Find the shortest path between two nodes.
     *
     * @param a Starting node
     * @param b Destination node
     * @return The shortest path
     */
    public static List<Node> find(Node a, Node b) {
        // Return null if one of the nodes is
        // null or if they are the same
        if (a == null || b == null || a == b){
            return null;
        }

        // Setup a queue for BFS
        Queue<Node> toVisit = new LinkedList<Node>();

        // Setup parents to retrace steps to the shortest path
        HashMap<Node, Node> parents = new HashMap<Node, Node>();

        // Add starting node to the queue
        // Which has no parent
        toVisit.add(a);
        parents.put(a, null);

        // Keep going until we run out of nodes
        // or reach our destination
        while (!toVisit.isEmpty()) {
            // Remove initial starting node
            Node current = toVisit.remove();

            // If the destination is reached
            // we break out of the loop
            if (current == b) {
                break;
            }

            // If the current node doesn't have children, skip it
            if (current.children == null) {
                continue;
            }

            // Add all the children to the queue
            for (Node node : current.children) {
                if (!parents.containsKey(node)) {
                    toVisit.add(node);
                    parents.put(node, current);
                }
            }
        }

        // If we couldn't find a path, the destination node
        // won't have been added to our parents set
        if (parents.get(b) == null) {
            return null;
        }

        // Create the result list and add the path to the list
        List<Node> result = new LinkedList<Node>();
        Node node = b;
        while (node != null) {
            result.add(0, node);
            node = parents.get(node);
        }

        return result;
    }
}