public class RunwayReservation {
    static class Node {
        int key;
        Node leftChild;
        Node rightChild;
        int size;
        Node(int data) {
            this.key = data;
            this.leftChild = null;
            this.rightChild = null;
            this.size = 0;
        }
    }
    static class BST {
        Node root;
        BST(Node root) {
            this.root = root;
        }
        public void insert(int data) {
            this.root = insertOp(this.root, data);   
        }
        public static Node insertOp(Node curr, int data) {
            int k = 4;
            // System.out.println(curr.key + " size: " +  curr.size + " data: "  + data);
            // System.out.println(curr.key + " " + data);
            if (data - curr.key > k || data - curr.key < -1*k) {
                curr.size += 1;
                if (data <= curr.key) {
                    if (curr.leftChild != null) {
                        insertOp(curr.leftChild, data);
                    }
                        else {
                        if (data >= curr.key) {
                            curr.rightChild = new Node(data);
                            curr.rightChild.size += 1;
                        } 
                        else if (data <= curr.key) {
                            curr.leftChild = new Node(data);
                            curr.leftChild.size += 1;
                        }
                    }
                }
                else if (data >= curr.key) {
                    if (curr.rightChild != null) {
                        insertOp(curr.rightChild, data);
                    }
                    else {
                        if (data >= curr.key) {
                            curr.rightChild = new Node(data);
                        } 
                        else if (data <= curr.key) {
                            curr.leftChild = new Node(data);
                        }
                    }
                }
            } else {
                System.out.println("//////Can't insert " + data);
            }
            return curr;
        }
    }
    static class Solver{
        public static void solve() {
            BST bst = new BST(new Node(40));
            bst.insert(41);
            bst.insert(44);
            bst.insert(26);
            bst.insert(46);
            bst.insert(33);
            bst.insert(36);
            bst.insert(38);
            bst.insert(64);
            bst.insert(22);
            bst.insert(18);
            System.out.println(bst.root.size);
        }
    }
    public static void main(String args[]) {
      Solver solver = new Solver();
      solver.solve();
    }
}