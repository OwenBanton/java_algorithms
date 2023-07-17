// Owen Banton

package javaProjects.OwenBantonA2;

public class TreeMain {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        Worker A = new Worker("A", 24000);
        Worker B = new Worker("B", 226000);
        Worker C = new Worker("C", 23000);
        Worker D = new Worker("D", 34000);
        Worker E = new Worker("E", 54000);
        Worker F = new Worker("F", 124000);
        Worker G = new Worker("G", 12300);
        Worker H = new Worker("H", 123500);
        Worker Z = new Worker("Z", 123500);
        Worker Q = new Worker("Q", 123500);

        binaryTree.setRoot(A);
        binaryTree.setLeft(A, B);
        binaryTree.setRight(A, C);
        binaryTree.setLeft(B, D);
        binaryTree.setRight(B, E);
        binaryTree.setRight(E, G);
        binaryTree.setRight(G, F);
        binaryTree.setLeft(D, H);
        binaryTree.setLeft(F, Z);

        System.out.println("Tree size: " + binaryTree.size());

        System.out.println("Root of tree: " + binaryTree.root());

        System.out.println("Parent of C: " + binaryTree.parent(C));
        System.out.println("Parent of F: " + binaryTree.parent(F));

        System.out.println("Right child of A: " + binaryTree.right(A));
        System.out.println("Left child of B: " + binaryTree.left(B));

        System.out.println(binaryTree);

        System.out.println(binaryTree.treeH(binaryTree.root));
    }


}
