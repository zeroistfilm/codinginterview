public class 노드사이의경로 {
    public static void main(String[] args) {
        CustomGraph graph = new CustomGraph(7);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        System.out.println(graph.search(0, 4)); // true
        System.out.println(graph.search(4, 6)); // false
    }
}
