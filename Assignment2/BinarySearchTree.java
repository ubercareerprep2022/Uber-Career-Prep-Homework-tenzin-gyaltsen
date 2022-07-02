package Assignment2;

public class BinarySearchTree {

  public static class Node {
    public int key;
    public Node left;
    public Node right;

    public Node(int key) {
      this.key = key;
      left = null;
      right = null;
    }
  }

  private Node root;

  public BinarySearchTree(int rootValue) {
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
  public Node insert(Node root, int key) {
    // Please implement this method.
    if (root == null) {
      root = new Node(key);
      return root;
    }

    if (key < root.key) {
      root.left = insert(root.left, key);
    } else if (key > root.key) {
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
  public boolean find(Node currRoot, int key) {
    // Please implement this method.
    if (currRoot == null) {
      return false;
    }

    if (key == currRoot.key) {
      return true;
    }

    if (key < currRoot.key) {
      return find(currRoot.left, key);
    } else if (key > currRoot.key) {
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

  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree(15);
    tree.insert(tree.getRoot(), 20);
    tree.insert(tree.getRoot(), 5);
    tree.insert(tree.getRoot(), 1);

    tree.printInorder(tree.getRoot());

    System.out.println("");
    System.out.println(tree.find(tree.getRoot(), 20));
    System.out.println(tree.find(tree.getRoot(), 15));
    System.out.println(tree.find(tree.getRoot(), 5));
  }
}
