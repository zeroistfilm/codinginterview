package chapter4;

import com.sun.source.tree.Tree;
import org.javatuples.Pair;
import org.javatuples.Tuple;

import java.util.List;

public class DetermineOrder {


    public List<Pair<TreeNode, TreeNode>> toTreeNodes(List<Pair<String, String>> orders) {
        return orders.stream().map(
                pair -> new Pair<>(new TreeNode(pair.getValue0()), new TreeNode(pair.getValue1()))
        ).toList();
    }

    public TreeNode setOrder(List<Pair<TreeNode, TreeNode>> orders) {
        System.out.println("포기");
        return new TreeNode("3");

    }

    private void addOrder(String a, String b) {
        TreeNode A = new TreeNode(a);
        TreeNode B = new TreeNode(b);

        A.addChild(B);
    }
}
