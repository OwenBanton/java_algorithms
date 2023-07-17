// Owen Banton

package javaProjects.OwenBantonA2;

/**
 * Node class to hold the worker objects and allow for the use of pointers to navigate the tree due to limited attributes of worker class.
 */
public class TreeNode {

    Worker worker;
    TreeNode parent; // Pointers for parent of the node, as well as each child.
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode() {
    }

    public TreeNode(Worker worker, TreeNode parent) { // Constructor for the tree node.
        this.worker = worker;
        this.parent = parent;
    }

    public TreeNode(Worker worker) {
        this.worker = worker;
    }

    public TreeNode(Worker worker, TreeNode parent, TreeNode leftChild, TreeNode rightChild) {
        this.worker = worker;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
