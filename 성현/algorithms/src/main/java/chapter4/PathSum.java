package chapter4;

public class PathSum {

    public int pathSum(BinaryTree node, int currentSum, int target) {
        int answer = 0;
        if (checkSum(node, currentSum, target))
        {
            answer += 1;
        }
        if (node.left != null) {
            answer += pathSum(node.left, currentSum += node.data, target);
        }
        if (node.right != null) {
            answer += pathSum(node.right, currentSum += node.data, target);
        }


        return answer;
    }

    public boolean checkSum(BinaryTree node, int currentSum, int target) {
        return node.data + currentSum == target;
    }
}
