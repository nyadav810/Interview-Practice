package data.structures.tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeProblems {

   static class TreeNode {
      int data;
      TreeNode left;
      TreeNode right;
      
      TreeNode(int x) {
         data = x;
      }
   }

   public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            
            System.out.print(current.data + " ");
            
            //int level = getLevel(root, current.data);
            // if (list.get(level) == null) {
//                 List<Integer> newList = new ArrayList<Integer>();
//                 list.add(level, newList);
//             }
            
            //list.get(level).add(current.data);
            
            if (current.left != null) {
               queue.add(current.left);
            }
            
            if (current.right != null) {
               queue.add(current.right);
            }
        }
        System.out.println();
        
        return list;
    }
    
    public static int getLevel(TreeNode root, int target) {
        return getLevel(root, target, 0);
    }
    
    private static int getLevel(TreeNode root, int target, int level) {
        if (root == null) {
            return 0;
        }
        
        if (root.data == target) {
            return level;
        } else {
            int downLevel = getLevel(root.left, target, level + 1);
            if (downLevel != 0) {
                return downLevel;
            }
            
            downLevel = getLevel(root.right, target, level + 1);
            return downLevel;
        }
    } 
    
    // construct a binary tree from an array of integers
    // left child = 2n + 1
    // right child = 2n + 2
    // parent = (n - 1) / 2
    private static TreeNode constructTree(int[] a) {
        return insertLevelOrder(a, new TreeNode(a[0]), 0);
    }
    
    private static TreeNode insertLevelOrder(int[] a, TreeNode root, int i) {
        if (i < a.length) {
            TreeNode temp = new TreeNode(a[i]);
            root = temp;
            
            root.left = insertLevelOrder(a, root.left, 2 * i + 1);
            root.right = insertLevelOrder(a, root.right, 2 * i + 2);
            
            if (root.data == Integer.MIN_VALUE) {
               root = null;
            }
        }
        
        return root;
    }
    
    private static void testLevelOrder() {
        int[] a = { 3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7 };
        
        levelOrder(constructTree(a));
    }
    
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    
    public static void testCountNodes() {
        int[] a = { 3, 9, 20, 1, 33, 15, 7 };
        
        System.out.println(countNodes(constructTree(a)));
    }


    
    public static TreeNode deepestNode(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        } else {
            
        }
    }
    
    public static void main(String[] args) {
        testCountNodes();
    }
}