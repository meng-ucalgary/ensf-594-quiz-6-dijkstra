/**
 * Represents a vertex of the graph
 */
public class Vertex {
    public char label;
    public boolean visited;

    /**
     * Construct a vertex with label l
     *
     * @param l the label of the vertex
     */
    public Vertex(char l) {
        this.label = l;
        this.visited = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.valueOf(label);
    }
}
