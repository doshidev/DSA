public class BSTSuccessor {
    public static void main(String[] args) {
        test(new int[] {50, 25, 75, 12, 37, 62, 87, 6, 18, 31, 43, 56, 68, 81, 93}, new int[]{0, 31, 26, 50, 100, 76, 84});

    }


    static void test(int[] input, int[] test) {
        Node bstRoot = createBST(input);
        for (int i = 0; i < test.length; i++) {
            System.out.println("Successor of " + test[i] + " is " + findSuccessor(bstRoot, test[i]));
        }
    }


    static Integer findSuccessor(Node bstRoot, int key) {
        boolean found = false;
        int result = -1;
        Node current = bstRoot;
        while (current != null) {
            if(key < current.data) {
                result = current.data;
                found = true;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return found ? result : null;

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
            if(key <= current.data) {
                if(current.left != null) {
                    current = current.left;
                } else {
                    current.left = new Node(key);
                    return;
                }
            } else {
                if(current.right != null) {
                    current = current.right;
                } else {
                    current.right = new Node(key);
                    return;
                }
            }
        }
    }
}
