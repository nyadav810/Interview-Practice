package algorithms.search.breadth.first;

import java.util.Queue;
import java.util.LinkedList;

public class BreadthFirstSearch {

    class Node {
        public int data;
        public Node[] neighbors;
    }

    public static void bfs(Node root) {
        Queue<Node> queue = new LinkedList<Node>();

        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
        }
    }

    public static void main(String[] args) {

    }
}
