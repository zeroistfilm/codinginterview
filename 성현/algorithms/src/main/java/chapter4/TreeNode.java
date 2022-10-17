package chapter4;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TreeNode {

    String data;
    TreeNode parent;
    List<TreeNode> children = new ArrayList<>();

    public TreeNode(String data) {
        this.data = data;
    }

    public void addChild(TreeNode child) {
        this.children.add(child);
        child.setParent(this);
    }

    private void setParent(TreeNode parent) {
        if (this.children.contains(parent)) {
            throw new RuntimeException("Invalid Operation. Child cannot be set as parent.");
        }
        this.parent = parent;
    }

    private TreeNode findNode(String data) {
        if (this.data.equals(data)) {
            return this;
        }
        for (TreeNode child : this.children) {
            findNode(data);
        }
        return null;
    }
}
