import java.util.PriorityQueue;

/**
 * Represents a graph using adjacency matrix
 */
public class Graph {
    private int vertexCount;
    private int maxVertices;
    private Vertex[] vertexList;
    private int[][] adjMatrix;

    /**
     * Constructs an empty graph with max possible vertices
     *
     * @param max maximum number of vertices
     */
    public Graph(int max) {
        this.vertexCount = 0;
        this.maxVertices = max;
        this.vertexList = new Vertex[this.maxVertices];
        this.adjMatrix = new int[this.maxVertices][this.maxVertices];
    }

    /**
     * Adds a vertex to the graph
     *
     * @param l the label of the vertex to be added
     * @return <code>true</code> if the vertex is added successfully,
     *         <code>false</code> otherwise
     */
    public boolean addVertex(char l) {
        // all vertices are going to be uppercase in our implementation
        char L = Character.toUpperCase(l);

        // check if the vertex already exists
        for (int i = 0; i < this.vertexCount; i++) {
            if (this.vertexList[i].label == L) {
                return false;
            }
        }

        this.vertexList[this.vertexCount++] = new Vertex(L);
        return true;
    }

    /**
     * Get the index of vertex with label l in the array vertexList
     *
     * @param l the label of vertex
     * @return index the vertex l
     */
    private int getVertexIndex(char l) {
        int pos = 0;
        for (pos = 0; pos < this.vertexCount; pos++) {
            if (this.vertexList[pos].label == l) {
                break;
            }
        }

        return pos;
    }

    /**
     * Adds an edge from vertex a to vertex b with the weight w
     *
     * @param a             starting vertex
     * @param b             edning vertex
     * @param w             weight of the edge
     * @param bidirectional <code>true</code> for a bidirectional edge,
     *                      <code>false</code> for unidirectional
     */
    public void addEdge(char a, char b, int w, boolean bidirectional) {
        a = Character.toUpperCase(a);
        b = Character.toUpperCase(b);

        // find the position of vertex a
        int aPos = this.getVertexIndex(a);

        // find the position of vertex b
        int bPos = this.getVertexIndex(b);

        this.adjMatrix[aPos][bPos] = w;

        if (bidirectional == true) {
            this.adjMatrix[bPos][aPos] = w;
        }
    }

    /**
     * Prints the divider for the adjacency matrix
     */
    private void printAdjMatrixDivider() {
        System.out.printf("+---+");
        for (int x = 0; x < this.vertexCount; x++) {
            System.out.printf("---+");
        }

        System.out.printf("%n");
    }

    /**
     * Prints the adjacency matrix to the stdout
     */
    public void printAdjMatrix() {
        // print the divider
        this.printAdjMatrixDivider();

        System.out.printf("|   |");

        // print the columns
        for (int x = 0; x < this.vertexCount; x++) {
            System.out.printf(" %c |", this.vertexList[x].label);
        }

        System.out.printf("%n");

        // print the divider
        this.printAdjMatrixDivider();

        for (int x = 0; x < this.vertexCount; x++) {
            // print the rows
            System.out.printf("| %c | ", this.vertexList[x].label);

            for (int y = 0; y < this.vertexCount; y++) {
                // print the weight
                System.out.printf("%d | ", this.adjMatrix[x][y]);
            }

            System.out.printf("%n");
        }

        // print the divider
        this.printAdjMatrixDivider();
    }

    /**
     * Prints the shortest distance from startingVertex from every other vertex of
     * the graph
     *
     * @param startingVertex vertex from where the shortest distance needs to be
     *                       printed
     */
    public void dijkstra(char startingVertex) {
        boolean[] toBeChecked = new boolean[this.vertexCount];
        int[] currentDistance = new int[this.vertexCount];
        char[] predecessor = new char[this.vertexCount];

        // get position of startingVertex
        int pos = this.getVertexIndex(startingVertex);

        // initialize toBeChecked
        for (int i = 0; i < toBeChecked.length; i++) {
            toBeChecked[i] = true;
        }

        // initialize the currentDistance as -1 for all except the startingVertex
        for (int i = 0; i < currentDistance.length; i++) {
            if (i == pos) {
                currentDistance[i] = 0;
            }

            else {
                currentDistance[i] = -1;
            }
        }

        // initialize predecessor
        for (int i = 0; i < predecessor.length; i++) {
            predecessor[i] = '-';
        }

        PriorityQueue<PriorityVertex> pq = new PriorityQueue<>(new SortVertex());
        pq.add(new PriorityVertex(this.vertexList[pos], currentDistance[pos]));

        while (!pq.isEmpty()) {
            char currentVertex = pq.poll().v.label;
            pos = this.getVertexIndex(currentVertex);
            toBeChecked[pos] = false;

            // check all adjacent vertices
            for (int i = 0; i < this.vertexCount; i++) {

                // i becomes the index of adjacent vertex
                if (this.adjMatrix[pos][i] > 0) {
                    if (toBeChecked[i] == false) {
                        continue;
                    }

                    else {
                        int newDistance = currentDistance[pos] + this.adjMatrix[pos][i];

                        if (currentDistance[i] == -1 || newDistance < currentDistance[i]) {
                            currentDistance[i] = newDistance;
                            pq.add(new PriorityVertex(this.vertexList[i], currentDistance[i]));
                        }

                        predecessor[i] = currentVertex;
                    }
                }
            }
        }

        System.out.printf("| Vertex | ToBeChecked | Distance | Predecessor |%n");
        System.out.printf("+--------+-------------+----------+-------------+%n");
        for (int i = 0; i < currentDistance.length; i++) {
            System.out.printf("| %6c | %11s | %8d | %11c |%n", this.vertexList[i].label, toBeChecked[i],
                    currentDistance[i], predecessor[i]);
        }
    }
}
