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
    public void delete(int k) {
        root = delete(root, k);
    }
    private Node delete(Node root, int k) {
        if (root == null) return null;
        if (root.val == k) {
            if (root.left == null && root.left == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node nextMax = findNextMax(root.right);
                root.val = nextMax.val;
                nextMax.val = k;
                root.right = delete(root.right, k);
            }
        } else if (root.val > k) {
            root.left = delete(root.left, k);
        } else {
            root.right = delete(root.right, k);
        }
        return root;
    }

    private Node findNextMax(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

}
