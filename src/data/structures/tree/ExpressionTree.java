package data.structures.tree;

import java.util.Stack;

public class ExpressionTree {
    private class TreeNode {
        char data;
        TreeNode left;
        TreeNode right;

        TreeNode(char data) {
            this(data, null, null);
        }

        TreeNode(char data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        
        public String toString() {
            return Character.toString(this.data);
        }
    }

    private Stack<TreeNode> stack;

    public ExpressionTree() {
        stack = new Stack<TreeNode>();
    }


    public TreeNode evaluatePostfix(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("improperly formatted postfix string");
                }
                TreeNode operand1 = stack.pop();
                TreeNode operand2 = stack.pop();

                TreeNode newNode = new TreeNode(c, operand2, operand1);
                stack.push(newNode);
            } else {
                stack.push(new TreeNode(c));
            }
        }
        return stack.pop();
    }

    public void printPostorder(TreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(root.toString() + " ");
        }
    }

    public static void main(String[] args) {
        String postFixExpression = "ab+cde+**";
        ExpressionTree tree = new ExpressionTree();
        tree.printPostorder(tree.evaluatePostfix(postFixExpression));
    }
}
