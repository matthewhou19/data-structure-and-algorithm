import java.util.*;

public class node_undirected_grah {
    private static class Node{
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }



    public static void main(String[] args) {
        Node origin= node_undirected_grah.setGraph();
        Node copy = cloneGraph(origin);

    }

    private static Node setGraph() {
        Node sentinel = new Node(0);
        Node num1 = new Node(1);
        Node num2 = new Node(2);
        Node num3 = new Node(3);
        Node num4 = new Node(4);
        num1.neighbors.add(num2);
        num1.neighbors.add(num4);
        num2.neighbors.add(num1);
        num2.neighbors.add(num3);
        num3.neighbors.add(num2);
        num3.neighbors.add(num4);
        num4.neighbors.add(num1);

        num4.neighbors.add(num3);
        sentinel.neighbors.add(num1);
        return sentinel.neighbors.get(0);
    }

    private static Node cloneGraph(Node node) {
        if (node == null) return null;
        Node head = new Node(node.val);
        Map<Node, Node> map = new HashMap<>();
        map.put(node,head);
        Helper(head, node, map);
        return head;
    }

    private static void Helper(Node head, Node node, Map<Node, Node> map) {
        for (Node n : node.neighbors) {
            if (!map.containsKey(n)) {
                Node copy  =new Node(n.val);
                head.neighbors.add(copy);
                map.put(n, copy);
                Helper(copy, n, map);
            } else {
                Node copy = map.get(n);
                head.neighbors.add(copy);
            }
        }

    }


}
