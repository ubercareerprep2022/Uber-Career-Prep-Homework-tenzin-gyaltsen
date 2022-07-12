package Assignment2;

import java.util.Comparator;

public class BSPhoneTree {

    public static class Node {
        public phoneNumber key;
        public Node left;
        public Node right;

        public Node(phoneNumber key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    private Node root;

    public BSPhoneTree(phoneNumber rootValue) {
        root = new Node(rootValue);
    }

    public Node getRoot() {
        return root;
    }

    /**
     * Inserts a key into this binary search tree.
     * If there are n nodes in the tree, then the average runtime of this method
     * should be log(n).
     * 
     * @param key The key to insert.
     */
    public Node insert(Node root, phoneNumber key) {
        // Please implement this method.
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (compare(key.getName(), root.key.getName()) < 0) {
            root.left = insert(root.left, key);
        } else if (compare(key.getName(), root.key.getName()) > 0) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    /**
     * Checks whether or not a key exists in this binary search tree.
     * If there are n nodes in the tree, then the average runtime of this method
     * should be log(n).
     * 
     * @param key The key to check for.
     * @return true if the key is present in this binary search tree, false
     *         otherwise.
     */
    public long find(Node currRoot, phoneNumber key) {
        // Please implement this method.
        if (currRoot == null) {
            return -1;
        }

        if (key.getName()== currRoot.key.getName()) {
            return currRoot.key.getPhoneNumber();
        }

        if (compare(key.getName(), currRoot.key.getName()) < 0) {
            return find(currRoot.left, key);
        } else if (compare(key.getName(), currRoot.key.getName()) > 0) {
            return find(currRoot.right, key);
        }

        return -1;
    }

    public void printInorder(Node root) {
        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.println(root.key.getName() + " " + root.key.getPhoneNumber());
        printInorder(root.right);
    }

    public int compare(String a, String b) {
        if(a.charAt(0) > b.charAt(0)){
            return 1;
        } else if (a.charAt(0) < b.charAt(0)){
            return -1;
        } else {
            return 1;
        }
    }

}
