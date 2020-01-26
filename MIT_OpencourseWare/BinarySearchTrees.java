// Used to solve runway reservation in O(h) time
// Can be used in comparision where order doesn't matter and questions 
// such as successor/predecessor, or how many greater or less than sth
// This is a AVL Tree without rotation, which is 
// a BST
public class MyClass {
    public static void main(String args[]) {
      AVLTree at = new AVLTree(new Node(40));
      at.insert(new Node(26));
      at.insert(new Node(33));
      at.insert(new Node(18));
      at.insert(new Node(46));
      at.insert(new Node(64));
      System.out.println(at.root.height);
    }
    static class Node {
        Node leftChild;
        Node rightChild;
        int data;
        int height;
        public Node(int data) {
            this.leftChild = null;
            this.rightChild = null;
            this.data = data;
            int height = 0;
        }
    }
    static class AVLTree {
        Node root;
        public AVLTree (Node root) {
            this.root = root;
        }
        public int height(Node curr) {
            int h = curr == null ? -1 : curr.height;
            return h;
        }
        public int max(int a, int b) {
            int m = a > b ? a : b;
            return m;
        }
        public void insert(Node node) {
            this.root = insert(node, this.root);
        }
        public Node insert(Node node, Node curr) {
            if (curr == null) {
                curr = node;
            }
            else if (node.data <= curr.data) {
                curr.leftChild = insert(node, curr.leftChild);
            }
            else {
                curr.rightChild = insert(node, curr.rightChild);
            }
            curr.height = max(height(curr.leftChild), height(curr.rightChild)) + 1;
            return curr;
        }
    }
}