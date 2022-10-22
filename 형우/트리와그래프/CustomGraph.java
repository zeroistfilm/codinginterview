import java.util.LinkedList;

class CustomGraph {
    Node[] nodes;

    CustomGraph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    // 노드간의 간선 연결
    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    // 최소 탐색시 방문정보 초기화
    void initMarks() {
        for (Node n : nodes) {
            n.marked = false;
        }
    }

    boolean search(int i1, int i2) {
        return search(nodes[i1], nodes[i2]);
    }

    // bfs
    private boolean search(Node start, Node end) {
        initMarks();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Node root = queue.removeFirst();
            if (root == end) {
                return true;
            }
            for (Node node : root.adjacent) {
                if (!node.marked) {
                    node.marked = true;
                    queue.add(node);
                }
            }
        }
        return false;
    }

    // CustomGraph 노드 정보
    class Node {
        int data;
        boolean marked; // 방문 정보
        LinkedList<Node> adjacent; // 인접 노드

        Node(int data) {
            this.data = data;
            this.marked = false;
            this.adjacent = new LinkedList<>();
        }
    }
}
