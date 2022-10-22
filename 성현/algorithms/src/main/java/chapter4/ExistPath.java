package chapter4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExistPath {

    /** nodeA와 nodeB 사이에 경로가 있는지 확인하는 함수 **/
    public boolean ExistPath(List<List<Integer>> adjacentList, int nodeA, int nodeB) {
        Set<Integer> availablePathFromA = findAllPath(adjacentList, nodeA);
        Set<Integer> availablePathFromB = findAllPath(adjacentList, nodeB);

        if (availablePathFromA.contains(nodeB) && availablePathFromB.contains(nodeA)) {
            return true;
        }

        return false;
    }

    /** 특정 노드에서 접근 가능한 모든 노드를 리턴하는 함수 */
    private Set<Integer> findAllPath(List<List<Integer>> adjacentList, int node) {

        List<Integer> availablePaths = new ArrayList<>(adjacentList.get(node));
        Set<Integer> visitedNodes = new HashSet<>();
        int idx = 0;


        while (idx < availablePaths.size()) {
            Integer visitedNode = availablePaths.get(idx);
            visitedNodes.add(idx);
            idx += 1;

            /** 방문하지 않은 노드인 경우 해당 노드에서 접근 가능한 경로들을 추가한다.*/
            if (!visitedNodes.contains(visitedNode)) {
                availablePaths.addAll(adjacentList.get(visitedNode));
            }
        }

        return visitedNodes;
    }
}
