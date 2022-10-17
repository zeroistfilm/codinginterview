package TreeAndGraph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DecideOrder {

  public static void main(String[] args) {
    String result = new NodeMap(List.of("a", "b", "c", "d", "e", "f"))
        .applyDependency("a", "d")
        .applyDependency("f", "b")
        .applyDependency("b", "d")
        .applyDependency("f", "a")
        .applyDependency("d", "c")
        .checkDependency()
        .priorityOrder()
        .toString();
    System.out.println(result);
  }

  private static class Node {

    private final String data;
    private final Collection<Node> edges;

    public Node(String data) {
      this.data = data;
      this.edges = new LinkedList<>();
    }

    public void addEdge(Node edge) {
      edges.add(edge);
    }

    @Override
    public int hashCode() {
      return data.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
      if (obj.getClass() != Node.class) {
        return false;
      }
      return data.equals(((Node) obj).data);
    }

    @Override
    public String toString() {
      return data;
    }
  }

  public static class NodeMap {

    private final Map<String, Node> nodesMap;
    private final Map<Node, Integer> dependencies;

    public NodeMap(Collection<String> projects) {
      this.nodesMap = new HashMap<>();
      this.dependencies = new HashMap<>();
      for (String project : projects) {
        Node newNode = new Node(project);
        nodesMap.put(project, newNode);
        dependencies.put(newNode, 0);
      }
    }

    public NodeMap applyDependency(String from, String to) {
      Node sourceNode = nodesMap.get(from);
      sourceNode.addEdge(nodesMap.get(to));
      nodesMap.put(from, sourceNode);
      return this;
    }

    public NodeMap checkDependency() {
      for (Node node : nodesMap.values()) {
        Set<Node> footage = new HashSet<>();
        for (Node edge : node.edges) {
          dfs(edge, footage);
        }
      }
      return this;
    }

    public List<Project> priorityOrder() {
      return dependencies.entrySet()
          .stream()
          .map(entry -> new Project(entry.getKey(), entry.getValue()))
          .sorted()
          .toList();
    }

    private void dfs(Node to, Set<Node> footage) {
      if (footage.contains(to)) {
        return;
      }
      dependencies.compute(to, (key, value) -> value == null ? 0 : ++value);
      footage.add(to);
      for (Node edge : to.edges) {
        dfs(edge, footage);
      }
    }
  }

  public record Project(Node node, Integer priority) implements Comparable<Project> {

    @Override
    public int compareTo(Project o) {
      return this.priority.compareTo(o.priority);
    }

    @Override
    public String toString() {
      return node.toString();
    }
  }
}
