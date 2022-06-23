public class naiveBST implements BinarySearchTree{
    private class Node{
        private int val;
        private Node left;
        private Node right;
        public Node(int v) {
            val = v;
            left = null;
            right = null;
        }
    }

    Node root;
    public naiveBST(){
        root = null;
    }




    @Override
    public void insert(int k) {
        root =  insert(root, k);
    }
    private Node insert(Node root, int k) {
        if (root == null) {
            return new Node(k);
        }
        if (root.val > k) {
            root.left = insert(root.left, k);
        } else if (root.val < k) {
            root.right = insert(root.right, k);
        }
        return root;
    }


    @Override
    public boolean find(int k) {

        return find(root, k);
    }

    private boolean find(Node root, int k) {
        if (root == null) return false;
        if (root.val == k) return  true;
        if (root.val > k) {
            return find(root.left, k);
        } else {
            return find(root.right, k);
        }
    }

    @Override
    public boolean delete(int k) {
        return delete(root, k);
    }
    private boolean delete(Node root, int k) {
        if (root == null) return false;
        
    }

}
