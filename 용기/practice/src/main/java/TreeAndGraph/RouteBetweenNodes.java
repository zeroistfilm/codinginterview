package TreeAndGraph;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 4-1 노드 사이의 경로 : 방향 그래프가 주어졌을 때 두 노드 사이에 경로가 존재하는지 화인하는 알고리즘을 작성하라.
 */
public class RouteBetweenNodes {

  public static void main(String[] args) {

    List<Node> nodes = new LinkedList<>();
    RouteMap routeMap = new RouteMap();

    for (Node from : nodes) {
      for (Node to : from.edges) {
        routeMap.addRoute(from, to);
      }
    }
  }

  // Warshall 알고리즘 참고
  public static class RouteMap {

    // Key : 출발지, Value : 출발지에서 갈 수 있는 모든 경로 (간접 경로 포함)
    private final Map<Node, Set<Node>> map = new HashMap<>();

    public void addRoute(Node src, Node des) {
      Set<Node> destinations;

      // 이미 map안에 src에서 갈수 있는 경로가 존재한다면
      if (map.containsKey(src)) {
        destinations = map.get(src);

        Set<Node> candidates = map.getOrDefault(des, Collections.emptySet());
        // 만약 des로부터 갈 수 있는 또 다른 노드 하나라도 존재한다면 src의 경로에 추가해준다. (간접 경로 추가)
        if (!candidates.isEmpty()) {
          destinations.addAll(candidates);
        }
      } else {
        destinations = new HashSet<>();
      }

      destinations.add(des);
      map.put(src, destinations);
    }

    public boolean hasRoute(Node src, Node des) {
      if (!map.containsKey(src)) {
        return false;
      }
      return map.get(src).contains(des);
    }
  }

  public static class Node {

    private final List<Node> edges = new LinkedList<>();
  }
}
