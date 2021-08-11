public class App {
    public static void main(String[] args) throws Exception {

        // Example 1 - slides
        // --------------------------------------------------------------------------------
        Graph g1 = new Graph(9);
        g1.addVertex('A');
        g1.addVertex('B');
        g1.addVertex('C');
        g1.addVertex('D');
        g1.addVertex('E');
        g1.addVertex('F');
        g1.addVertex('G');
        g1.addVertex('H');
        g1.addVertex('I');

        g1.addEdge('A', 'B', 2, false);
        g1.addEdge('A', 'E', 4, false);
        g1.addEdge('A', 'D', 5, false);
        g1.addEdge('B', 'E', 1, false);
        g1.addEdge('C', 'B', 3, false);
        g1.addEdge('D', 'G', 2, false);
        g1.addEdge('E', 'F', 3, false);
        g1.addEdge('E', 'H', 6, false);
        g1.addEdge('F', 'C', 4, false);
        g1.addEdge('F', 'H', 3, false);
        g1.addEdge('G', 'H', 1, false);
        g1.addEdge('H', 'I', 1, false);
        g1.addEdge('I', 'F', 1, false);

        System.out.println("\n\nExample 1\n");

        g1.dijkstra('A');
        // --------------------------------------------------------------------------------

        // Example 2 - slides
        // --------------------------------------------------------------------------------
        Graph g2 = new Graph(6);
        g2.addVertex('1');
        g2.addVertex('2');
        g2.addVertex('3');
        g2.addVertex('4');
        g2.addVertex('5');
        g2.addVertex('6');

        g2.addEdge('1', '2', 7, false);
        g2.addEdge('1', '3', 9, false);
        g2.addEdge('1', '6', 14, false);
        g2.addEdge('2', '3', 10, false);
        g2.addEdge('2', '4', 15, false);
        g2.addEdge('3', '4', 11, false);
        g2.addEdge('3', '6', 2, false);
        g2.addEdge('4', '5', 6, false);
        g2.addEdge('6', '5', 9, false);

        System.out.println("\n\nExample 2\n");

        g2.dijkstra('1');
        // --------------------------------------------------------------------------------

        // Example 3 - quiz
        // --------------------------------------------------------------------------------
        Graph g3 = new Graph(6);
        g3.addVertex('S');
        g3.addVertex('A');
        g3.addVertex('B');
        g3.addVertex('C');
        g3.addVertex('D');
        g3.addVertex('E');

        g3.addEdge('S', 'A', 1, false);
        g3.addEdge('S', 'C', 5, false);
        g3.addEdge('C', 'A', 2, false);
        g3.addEdge('A', 'B', 2, false);
        g3.addEdge('B', 'C', 1, false);
        g3.addEdge('B', 'D', 5, false);
        g3.addEdge('C', 'D', 3, false);
        g3.addEdge('E', 'D', 0, false);

        System.out.println("\n\nExample 3\n");

        g3.dijkstra('S');
        // --------------------------------------------------------------------------------
    }
}
