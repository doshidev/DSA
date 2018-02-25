import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeRange {
    public static void main(String[] args) {
        test(new int[]{1,2,3,4,5}, 1, 5);
        test(new int[]{}, 1, 5);
        test(new int[]{1,2,3,4,5}, 5, 3);
    }

    public static int findNumbersInRange(Node root, int start, int end) {
        int result = 0;
        Queue<Node> notVisited = new LinkedList<>();
        if(root == null) return 0;
        notVisited.add(root);

        while(!notVisited.isEmpty()) {
            Node current = notVisited.remove();
            if(current.data >= start && current.data <= end) {
                result++;
            }

            if(current.left != null) notVisited.add(current.left);
            if(current.right != null) notVisited.add(current.right);
        }


        return result;
    }

    public static void test(int[] input, int start, int end) {
        printArray(input);
        System.out.println(start + ", " + end);
        System.out.println(findNumbersInRange(createTree(input), start, end));
        System.out.println();
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

    public static void printArray(int[] input) {
        System.out.print("{");

        for (int i = 0; i < input.length; i++) {
            if(i > 0) {
                System.out.print(", " + input[i]);
            } else {
                System.out.print(input[i]);
            }
        }
        System.out.println("}");
    }
}
