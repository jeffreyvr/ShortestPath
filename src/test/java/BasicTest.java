import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class BasicTest {
    public Node[] graph;

    /**
     * Setting up a graph for testing.
     */
    public void setup() {
        this.graph = new Node[5];

        for (int i = 0; i < this.graph.length; i++) {
            graph[i] = new Node(i);
        }

        this.graph[0].addChild(this.graph[1]);
        this.graph[0].addChild(this.graph[2]);
        this.graph[1].addChild(this.graph[4]);
        this.graph[2].addChild(this.graph[3]);
        this.graph[3].addChild(this.graph[0]);
    }

    @Test
    public void test_shortest_path_outcomes() {
        this.setup();

        assertEquals(Arrays.toString(ShortestPath.find(this.graph[0], this.graph[3]).toArray()), "[0, 2, 3]");
        assertEquals(Arrays.toString(ShortestPath.find(this.graph[0], this.graph[2]).toArray()), "[0, 2]");
        assertNotEquals(Arrays.toString(ShortestPath.find(this.graph[1], this.graph[4]).toArray()), "[0, 2]");
    }

    @Test
    public void test_should_return_null_on_finding_same_node() {
        this.setup();

        assertNull(ShortestPath.find(this.graph[1], this.graph[1]));
    }

    @Test
    public void test_should_return_null_on_non_reachable_path() {
        this.setup();

        assertNull(ShortestPath.find(this.graph[1], this.graph[3]));
    }
}