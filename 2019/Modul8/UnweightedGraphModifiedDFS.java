package Modul8;

import java.lang.reflect.Array;
import java.util.*;

public class UnweightedGraphModifiedDFS<V> extends UnweightedGraph<V> {
    /**
     * Construct an empty graph
     */
    public UnweightedGraphModifiedDFS() {
    }

    /**
     * Construct a graph from vertices and edges stored in arrays
     */
    public UnweightedGraphModifiedDFS(V[] vertices, int[][] edges) {
        super(vertices, edges);
    }

    /**
     * Construct a graph from vertices and edges stored in List
     */
    public UnweightedGraphModifiedDFS(List<V> vertices, List<Edge> edges) {
        super(vertices, edges);
    }

    /**
     * Construct a graph for integer vertices 0, 1, 2 and edge list
     */
    public UnweightedGraphModifiedDFS(List<Edge> edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    /**
     * Construct a graph from integer vertices 0, 1, and edge array
     */
    public UnweightedGraphModifiedDFS(int[][] edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    @Override
    public SearchTree dfs(int v) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        boolean[] isVisited = new boolean[vertices.size()]; //creates boolean IsVisited Array
        for (int i = 0; i < parent.length; i++) {   //fills Array with -1.
            parent[i] = -1; // Initialize parent[i] to -1
        }
        stack.add(v);               //adds vertex to stack
        while (!stack.isEmpty()) {  //runs until stack is empty
            v = stack.pop();
            if (!isVisited[v]) {    //if vertex is not visited add v to search order, and boolean isVisited is true.
                searchOrder.add(v);
                isVisited[v] = true; // Mark visited vertices
            }

            for (Edge e : neighbors.get(v)) {
                if (!isVisited[e.getV()]) { //checks if neighbor is visited.
                    stack.add(e.getV());
                    parent[e.getV()] = v;   // The parent of vertex e.v is v
                }
            }
        }
        return new SearchTree(v, parent, searchOrder);   // Return a search tree
    }

}
