package TreeAndGraph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 4-7 순서 정하기 : 프로젝트의 리스트와 프로젝트들 간의 종속 관계(즉, 프로젝트 쌍이 리스트로 주어지면 각 프로젝트 쌍에서 두 번째 프로젝트가 첫 번재 프로젝트에 조속되어 있다는
 * 뜻)가 주어졌을 대, 프로젝트를 수행해 나가느 순서를 찾으라. 유효한 순서가 존재하지 않으면 에러를 반환한다.
 */
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

  public static class NodeMap {

    // 프로젝트명에 해당하는 Node를 나타낸 맵.
    private final Map<String, Node> nodesMap;
    // 해당 노드(프로젝트)가 얼마나 많은 의존성을 가지고 있는가를 나타낸다.
    private final Map<Node, Integer> dependencyCountMap;

    public NodeMap(Collection<String> projects) {
      this.nodesMap = new HashMap<>();
      this.dependencyCountMap = new HashMap<>();
      for (String project : projects) {
        Node newNode = new Node(project);
        nodesMap.put(project, newNode);
        dependencyCountMap.put(newNode, 0);
      }
    }

    // 종속관계 (from, to)는 from 프로젝트가 to 프로젝트보다 우선 수행되어야한다는 것을 말한다.
    // from Node의 edges에 to Node를 추가한다.
    public NodeMap applyDependency(String from, String to) {
      Node fromNode = nodesMap.get(from);
      fromNode.addEdge(nodesMap.get(to));
      nodesMap.put(from, fromNode);
      return this;
    }

    /*
     * 1. 모든 노드를 순회한다.
     * 2. 각 노드에서 DFS로 갈 수 있는 모든 노드를 순회한다. 어떤 노드를 방문하면 방문한 노드에 count를 올린다.
     * 즉, 특정 프로젝트는 해당 노드의 count만큼 의존하고 있는 프로젝트가 있다.
     */
    public NodeMap checkDependency() {
      for (Node node : nodesMap.values()) {
        Set<Node> footage = new HashSet<>();
        for (Node edge : node.edges) {
          dfs(edge, footage);
        }
      }
      return this;
    }

    // count 오름차순으로 프로젝트를 나열한다. count가 적을수록 타 프로젝트에 덜 의존적인 프로젝트다.
    public List<Project> priorityOrder() {
      return dependencyCountMap.entrySet()
          .stream()
          .map(entry -> new Project(entry.getKey(), entry.getValue()))
          .sorted()
          .toList();
    }

    // 특정 노드를 방문하면 map에서 해당 노드의 카운트를 올린다. 그리고 edges를 방문한다.
    private void dfs(Node to, Set<Node> footage) {
      if (footage.contains(to)) {
        return;
      }
      dependencyCountMap.compute(to, (key, value) -> value == null ? 0 : ++value);
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
}
