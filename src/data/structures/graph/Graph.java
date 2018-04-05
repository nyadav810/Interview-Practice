package data.structures.graph;

/*
 * Graph ADT implemented using an int adjacency matrix.
 * Rows and columns represent vertices in the graph,
 * and values represent edge relationships (0 or 1).
 * Simple implementation, but uses a lot of space in memory.
 * Good representation for dense graphs.
 */
public class Graph {

    // Space complexity = O(V^2), where V = number of vertices
    private int[][] adjacencyMatrix;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    public Graph() {
        this(DEFAULT_CAPACITY);
    }

    public Graph(int vertices) {
        adjacencyMatrix = new int[vertices][vertices];
        size = vertices;
    }

    /*
     * Add an edge from v1 to v2. Throws
     * an IllegalArgumentException if vertices passed
     * are negative or greater than the size of the graph
     */
    public void addEdge(int v1, int v2) {
        if (v1 > size || v2 > size || v1 < 1 || v2 < 1) {
            throw new IllegalArgumentException("vertex cannot be negative or greater than " + size + ".");
        } 
        adjacencyMatrix[v1-1][v2-1] = 1;
        
        // undirected: add inverse
        adjacencyMatrix[v2-1][v1-1] = 1;
    }
    
    public void print() {
       System.out.print("   ");
       for (int i = 1; i <= adjacencyMatrix.length; i++) {
           System.out.printf(" %d", i);
       }
       System.out.println();
       for (int i = 0; i < adjacencyMatrix.length; i++) {
           System.out.print(i+1);
           if (i < 9) {
               System.out.print(" ");
           }
           System.out.print("|");
           for (int j = 0; j < adjacencyMatrix[i].length; j++) {
               System.out.printf(" %d", adjacencyMatrix[i][j]);
           }
           System.out.println(" |");
       }
    }
}
