import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDepthRecursive {
    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        test(new int[]{});
        test(new int[]{1});
        test(new int[]{1, 2});
    }

    public static int findDepth(Node root) {
        if(root == null) return 0;
        if (root.left == null && root.right == null) return 0;

        int left = (root.left == null) ? 0 : findDepth(root.left);
        int right = (root.right == null) ? 0 : findDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static void test(int[] input) {
        System.out.println(findDepth(createTree(input)));
    }

    public static Node createTree (int[] input) {
        if(input.length <= 0) return null;

        Node root = new Node(input[0]);
        Queue<Node> queue = new LinkedList<>();
        Node current = root;
        for (int i = 1; i < input.length; i++) {
            Node temp = new Node(input[i]);
            queue.add(temp);

            if(current.left == null) {
                current.left = temp;
            } else if(current.right == null) {
                current.right = temp;
                current = queue.remove();
            }
        }
        return root;
    }
}
