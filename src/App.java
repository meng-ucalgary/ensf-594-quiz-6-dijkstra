public class App {
    public static void main(String[] args) throws Exception {
        Graph g = new Graph(9);
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
        g.addVertex('G');
        g.addVertex('H');
        g.addVertex('I');

        g.addEdge('A', 'B', 2, false);
        g.addEdge('A', 'E', 4, false);
        g.addEdge('A', 'D', 5, false);
        g.addEdge('B', 'E', 1, false);
        g.addEdge('C', 'B', 3, false);
        g.addEdge('D', 'G', 2, false);
        g.addEdge('E', 'F', 3, false);
        g.addEdge('E', 'H', 6, false);
        g.addEdge('F', 'C', 4, false);
        g.addEdge('F', 'H', 3, false);
        g.addEdge('G', 'H', 1, false);
        g.addEdge('H', 'I', 1, false);
        g.addEdge('I', 'F', 1, false);

        g.printAdjMatrix();
    }
}
