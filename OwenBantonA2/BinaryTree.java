// Owen Banton

package javaProjects.OwenBantonA2;

import java.util.LinkedHashMap;

public class BinaryTree {

    public BinaryTree() {
    }

    public TreeNode root; // Declaring empty root node of the tree.

    /**
     * Simple function to access the root of the tree.
     *
     * @return the worker value contained in the root node.
     */
    public Worker root() {
        return root.worker;
    }

    /**
     * Function to set the root of the tree with conditions to maintain connections to any existing children of the root.
     *
     * @param r = worker object to be set as the new root of the tree.
     */
    public void setRoot(Worker r) {
        if (root == null) {
            TreeNode newRoot = new TreeNode(r, null);
            root = newRoot;
        } else if ((root.leftChild == null) && (root.rightChild != null)) {
            TreeNode newRoot = new TreeNode(r, null, null, root.rightChild);
            root = newRoot;
        } else if ((root.leftChild != null) && (root.rightChild == null)) {
            TreeNode newRoot = new TreeNode(r, null, root.leftChild, null);
            root = newRoot;
        } else if ((root.leftChild != null) && (root.rightChild != null)) {
            TreeNode newRoot = new TreeNode(r, null, root.leftChild, root.rightChild);
            root = newRoot;
        }
    }

    /**
     * Function to identify node containing worker as user input only indicates worker objects and does not reference nodes.
     * Doesn't properly function in the case of duplicate workers.
     *
     * @param node node for the function to visit and check, beginning with root and traversing through the tree recursively.
     * @param p    the worker specified by the user or function.
     * @return the node containing the specified worker.
     */
    public TreeNode findWorker(TreeNode node, Worker p) {
        if (node == null) {                                 // Case for empty tree.
            return null;
        }
        if (node.worker.equals(p)) {                        // Case for worker in the root.
            return node;
        }
        TreeNode leftResult = findWorker(node.leftChild, p);    // Recursion down through left nodes.
        if (leftResult != null) {
            return leftResult;
        }
        TreeNode rightResult = findWorker(node.rightChild, p);  // Recursion down through right nodes.
        if (rightResult != null) {
            return rightResult;
        }
        return null;                                            // Return null if specified worker isn't found.
    }

    /**
     * Function to return parent of a specified worker. Uses findWorker function to identify the worker's node and then uses the node's parent pointer.
     *
     * @param p = the worker whose parent the user wishes to find.
     * @return the parent worker of the specified worker.
     */
    public Worker parent(Worker p) {
        return findWorker(root, p).parent.worker;
    }

    /**
     * Function to return left child of a specified worker. Uses findWorker function to identify the worker's node and then uses the node's left child pointer.
     *
     * @param p = the worker whose left child the user wishes to find.
     * @return the left child worker of the specified worker.
     */
    public Worker left(Worker p) {
        return findWorker(root, p).leftChild.worker;
    }

    /**
     * Function to return right child of a specified worker. Uses findWorker function to identify the worker's node and then uses the node's right child pointer.
     *
     * @param p = the worker whose right child the user wishes to find.
     * @return the right child worker of the specified worker.
     */
    public Worker right(Worker p) {
        return findWorker(root, p).rightChild.worker;
    }

    /**
     * Function to set left child of a specified worker. New node containing the new worker is created with a pointer to the specified parent.
     * The node of the parent is then found and its left child pointer is updated to the new node.
     *
     * @param p = specified parent of the new worker.
     * @param c = new worker.
     * @return the new worker object.
     */
    public Worker setLeft(Worker p, Worker c) {
        TreeNode child = new TreeNode(c, findWorker(root, p));
        findWorker(root, p).leftChild = child;
        return c;
    }

    /**
     * Function to set right child of a specified worker. New node containing the new worker is created with a pointer to the specified parent.
     * The node of the parent is then found and its right child pointer is updated to the new node.
     *
     * @param p = specified parent of the new worker.
     * @param c = new worker.
     * @return the new worker object.
     */
    public Worker setRight(Worker p, Worker c) {
        TreeNode child = new TreeNode(c, findWorker(root, p));
        findWorker(root, p).rightChild = child;
        return c;
    }

    /**
     * Function to find the depth of a given node based on the number of ancestors.
     * Used to order tree nodes by depth for printing in order.
     *
     * @param node = tree node whose depth is to be calculated.
     * @return depth value.
     */
    public int depth(TreeNode node) {
        int depthCounter = 0;
        TreeNode buffer;
        buffer = node;
        while ((buffer != null) && (buffer.parent != null)) { // loop continues to add to the counter for each existing parent of the node.
            depthCounter++;
            buffer = buffer.parent;
        }
        return depthCounter;
    }

    static LinkedHashMap depthMap = new LinkedHashMap(); // Hash map to store nodes based on depth value.

    /**
     * Function to place nodes into a hashmap based on depth value.
     * Couldn't get this to function properly as it travels all the way down before visiting sibling nodes.
     * Wasn't sure how to implement a pointer to sibling nodes which would have simplified this process.
     * Map also might not be the best choice for this task as I wasn't able to sort the map by value, but depth must be stored in value due to duplicate values of depth.
     *
     * @param node to be added to the map, starting with root.
     * @return a map of all nodes and their corresponding depth value.
     */
    public LinkedHashMap depthMapper(TreeNode node) {
        depthMap.put(node.worker, depth(node));

        if (node.leftChild != null) {
            depthMapper(node.leftChild);
        }
        if (node.rightChild != null) {
            depthMapper(node.rightChild);
        }
        return depthMap;
    }

    // recursive function to mirror given tree
//    static void mirrorTree(TreeNode root) {
//        if (root == null) {      // base case
//            return;
//        }
//        if (root.getRight != null) {            // if node has two children, swap values and continue
//            if (root.getLeft != null) {
//                root.getRight.getValue() = root.getLeft().getValue();
//                mirrorTree(root.getRight);
//                mirrorTree(root.getLeft);
//            } else {                            // if only child, move it to the other side and stop recursion
//                root.setLeft(root.getRight);
//                root.setRight(null);
//            }
//        } else if (root.getLeft != null) {             // same as above, with else so it doesn't swap twice
//            if (root.getRight != null) {
//                root.getLeft.getValue() = root.getRight().getValue();
//                mirrorTree(root.getRight);
//                mirrorTree(root.getLeft);
//            } else {
//                root.setRight(root.getLeft);
//                root.setLeft(null);
//            }
//        }
//
//    }

    /**
     * Function that calls the depthMapper function to order the nodes (but not really) and then return the string value of the map keys (worker objects).
     *
     * @return String value of all the workers in the tree (name and salary).
     */
    public String toString() {
        if (root == null) {
            return null;
        } else {
            depthMapper(root);
            return depthMap.keySet().toString();
        }
    }

    /**
     * Function that calls the sizeFinder function so the user doesn't have to specify the root parameter.
     *
     * @return the number of nodes in the tree.
     */
    public int size() {
        return sizeFinder(root);
    }

    /**
     * Function to visit each child node and return the sum of the number of nodes visited plus 1 for the root.
     *
     * @param node = the node from which the function starts counting children. Only root is used in this case.
     * @return the integer number of nodes in the tree.
     */
    public int sizeFinder(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeFinder(node.leftChild) + sizeFinder(node.rightChild);
        }
    }

    // recursive height function using two helper methods and math.max function
    public int treeH(TreeNode node) {

        int left = leftHeight(node);        // calling height functions for left and right
        int right = rightHeight(node);

        return Math.max(left, right);
    }

    public int leftHeight(TreeNode node) {
        if (node == null) {             // base case
            return 0;
        } else {
            return 1 + treeH(node.leftChild); // add one to counter per depth, recur to treeH to visit both children
        }
    }

    public int rightHeight(TreeNode node) { // same as left, wasn't sure how to combine them
        if (node == null) {
            return 0;
        } else {
            return 1 + treeH(node.rightChild);
        }
    }

//    static StringBuilder treeString = new StringBuilder();
//
//    /**
//     * Another attempt at a print in order function
//     */
//
//   public void stringMaker(TreeNode node, int depth) {
//        if (depth(node) == depth) {
//            treeString.append("Name: " + node.worker.name + " Salary: " + node.worker.salary + "\n");
//        }
//        if (node.leftChild != null) {
//            stringMaker(node.leftChild, depth(node.leftChild));
//        }
//        if (node.rightChild != null) {
//            stringMaker(node.rightChild, depth(node.rightChild));
//        }
//    }

}