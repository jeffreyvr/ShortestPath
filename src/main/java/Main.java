public class Main {
    public Node[] graph;

    public static void main(String[] args) {
        (new Main()).example();
    }

    /**
     * Create an example of a graph and find
     * the shortest path between two nodes.
     */
    public void example() {
        this.graph = new Node[5];

        for (int i = 0; i < this.graph.length; i++) {
            graph[i] = new Node(i);
        }

        this.graph[0].addChild(this.graph[1]);
        this.graph[1].addChild(this.graph[2]);
        this.graph[1].addChild(this.graph[4]);
        this.graph[4].addChild(this.graph[1]);
        this.graph[3].addChild(this.graph[1]);

        System.out.println("Shortest path between 0 and 4: " + ShortestPath.find(this.graph[0], this.graph[4]));
    }
}