// Used to solve runway reservation in O(h) time
// Can be used in comparision where order doesn't matter and questions 
// such as successor/predecessor, or how many greater or less than sth
public class BinarySearchTrees {
    static class Node {
        Node leftChild;
        Node rightChild;
        int key;
        int size;
        public Node(int data) {
            this.leftChild = null;
            this.rightChild = null;
            this.key = data;
            this.size = 0;
        }
    }
    static class BST {
        Node root;
        public BST() {
            this.root = null;
        }
        public static void insert(Node ref, int num) {
            ref.size += 1;
            if (num <= ref.key) {
                if (ref.leftChild != null) {
                    insert(ref.leftChild, num);   
                } else {
                    ref.leftChild = new Node(num);
                    ref.leftChild.size += 1;
                }
            }
            else if (num > ref.key) {
                if (ref.rightChild != null) {
                    insert(ref.rightChild, num);
                } else {
                    ref.rightChild = new Node(num);  
                    ref.rightChild.size += 1;
                }
            }
        }
    }
    public static void main(String args[]) {
      BST bst = new BST();
      bst.root = new Node(42);
      bst.root.size = 1;
      bst.insert(bst.root, 21);
      bst.insert(bst.root, 26);
      bst.insert(bst.root, 28);
      bst.insert(bst.root, 34);
      bst.insert(bst.root, 70);
      System.out.println(bst.root.leftChild.key + "---->" + bst.root.key + "<------" + bst.root.rightChild.key);
      System.out.println(bst.root.size);
    }
}