package data.structures.tree;

public class BinaryTree {
    private class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this(data, null, null);
        }

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return Integer.toString(this.data);
        }
    }

    private TreeNode root;

    public BinaryTree(int max) {
        this.root = buildTree(1, max);
    }

    private TreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        }
        return new TreeNode(n, buildTree(2 * n, max), buildTree(2 * n + 1, max));
    }

    // TODO: allow arbitrary number of additions
    public void add(int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else if (root.left == null) {
            root.left = new TreeNode(data);
        } else if (root.right == null) {
            root.right = new TreeNode(data);
        } else {
            System.out.println("root has 2 children already");
        }
    }

    public void printPreorder() {
        System.out.println("Printing preorder... ");
        printPreorder(root);
        System.out.println();
    }

    private void printPreorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.toString() + " ");
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    public void printInorder() {
        System.out.println("Printing inorder...");
        printInorder(root);
        System.out.println();
    }

    private void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.toString() + " ");
            printInorder(root.right);
        }
    }

    public void printPostorder() {
        System.out.println("Printing postorder...");
        printPostorder(root);
        System.out.println();
    }

    private void printPostorder(TreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(root.toString() + " ");
        }
    }

    public void printSideways() {
        printSideways(root, 0);
    }

    private void printSideways(TreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(15);
        binaryTree.printPreorder();
        binaryTree.printInorder();
        binaryTree.printPostorder();
        binaryTree.printSideways();
    }
}