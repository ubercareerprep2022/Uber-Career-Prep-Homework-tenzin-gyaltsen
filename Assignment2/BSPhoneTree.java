package Assignment2;

import java.util.Comparator;

public class BSPhoneTree {

    public static class Node {
        public String key;
        public Node left;
        public Node right;

        public Node(String key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    private Node root;

    public BSPhoneTree(String rootValue) {
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
    public Node insert(Node root, String key) {
        // Please implement this method.
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (compare(key, root.key) < 0) {
            root.left = insert(root.left, key);
        } else if (compare(key, root.key) > 0) {
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
    public boolean find(Node currRoot, String key) {
        // Please implement this method.
        if (currRoot == null) {
            return false;
        }

        if (key == currRoot.key) {
            return true;
        }

        if (compare(key, currRoot.key) < 0) {
            return find(currRoot.left, key);
        } else if (compare(key, currRoot.key) > 0) {
            return find(currRoot.right, key);
        }

        return false;
    }

    public void printInorder(Node root) {
        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.key + " ");
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
