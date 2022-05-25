package Assignment2;

public class Tree {
    public TreeNode root;
  
    public Tree(TreeNode root) {
      this.root = root;
    }

    public void inOrderTraversal (TreeNode node) {
      if (node == null) {
        return;
      }

      inOrderTraversal((node.left));
      System.out.println(node.data + " ");
      inOrderTraversal(node.right);
    }

    public static void main(String[] args) {
      TreeNode leftChild = new TreeNode(6, null, null);
      TreeNode rightChild = new TreeNode(3, null, null);
      TreeNode left = new TreeNode(7, null, null);
      TreeNode right = new TreeNode(17, leftChild, rightChild);
      TreeNode root = new TreeNode(1, left, right);
      Tree tree = new Tree(root);

      System.out.println("Tree Nodes in Inorder Traversal");
      tree.inOrderTraversal(tree.root);
    }
}
  