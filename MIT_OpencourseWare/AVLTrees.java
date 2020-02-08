public class AVLTrees {
    static class Node {
        int data;
        Node left;
        Node right;
        int height;
        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 0;
        }
    }
    static class AVLTree {
        Node root;
        public AVLTree(Node root) {
            this.root = root;
        }
        // Rotations
        public Node rotateOnceWithLeft(Node curr) {
            // reference residual cases when leftChild 
            // of root might have its right subtree
            Node a = curr.left;
            Node b = a.right;
            
            // rotate
            a.right = curr;
            curr.left = b;
            
            // update heights by seeing what changed in a diagram
            curr.height = max(height(curr.left), height(curr.right)) + 1; 
            a.height = max(height(a.left), height(a.right)) + 1; 
               
            return a;
        }
        /**
         * See left rotation for more insights as it is similar
         **/
        public Node rotateOnceWithRight(Node x) {
            Node y = x.right; 
            Node T2 = y.left; 
      
            // Perform rotation 
            y.left = x; 
            x.right = T2; 
      
            //  Update heights 
            x.height = max(height(x.left), height(x.right)) + 1; 
            y.height = max(height(y.left), height(y.right)) + 1; 
      
            // Return new root 
            return y; 
        }
        public int height(Node a) {
            int res = a == null ? -1 : a.height;
            return res;
        }
        public int max (int a, int b) {
            int res = a >= b ? a : b;
            return res;
        }
        public void insert(Node node) {
            this.root = insert(this.root, node);
        }
        public Node insert(Node curr, Node node) {
            if (curr == null) {
                curr = node;
            } 
            else if (node.data <= curr.data) {
                curr.left = insert(curr.left, node);
                if (height(curr.left) - height(curr.left) == 2) {
                    if (node.data < curr.data) {
                        // left inserted
                        curr = rotateOnceWithLeft(curr);
                    } 
                    // else {
                    //     curr = doubleRotateWithLeft(curr);
                    // }
                }
            }
            else {
                curr.right = insert(curr.right, node);
                if (height(curr.right) - height(curr.left) == 2) {
                    if (node.data > curr.data) {
                        // right inserted to right subtree
                        curr = rotateOnceWithRight(curr);
                    } 
                    // else {
                    //     curr = doubleRotateWithRight(curr);
                    // }
                }
            }
            curr.height = max(height(curr.left), height(curr.right)) + 1;
            return curr;
        }
    }
    public static void main(String args[]) {
      AVLTree at = new AVLTree(new Node(50));
      at.insert(new Node(26));
      System.out.println(at.root.height);
    }
}