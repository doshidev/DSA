public class BSTPredecessor {
    public static void main(String[] args) {
        test(new int[] {50, 25, 75, 12, 37, 32, 38}, new int[]{0, 31});

    }


    static void test(int[] input, int[] test) {
        Node bstRoot = createBST(input);
        for (int i = 0; i < test.length; i++) {
            System.out.println("Predecessor of " + test[i] + "is " + findPredecessor(bstRoot, test[i]));
        }
    }


    static int findPredecessor(Node bstRoot, int key) {
        if(bstRoot == null) return -1;
        Node current = bstRoot;
        while (true) {
            if(key <= current.data) {
                if(current.left == null) return current.data;
                // if(current.left.data <= key) return current.left.data;
                current = current.left;
            } else {
                if(current.right == null) return current.data;
                // if(current.right.data > key) return current.right.data;
                current = current.right;
            }
        }

    }


    static Node createBST(int[] input) {
        if(input.length <= 0) return null;
        Node root = new Node(input[0]);

        for (int i = 1; i < input.length; i++) {
            insertNode(root, input[i]);
        }
        return root;
    }

    static void insertNode(Node root, int key) {
        Node current = root;
        while(true) {
            if(key <= root.data) {
                if(current.left != null) {
                    current = current.left;
                } else {
                    current.left.data = key;
                    return;
                }
            } else {
                if(current.right != null) {
                    current = current.right;
                } else {
                    current.right.data = key;
                    return;
                }
            }
        }
    }
}
