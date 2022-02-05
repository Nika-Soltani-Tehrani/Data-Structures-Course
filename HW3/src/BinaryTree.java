import java.util.Scanner;
import java.util.regex.Pattern;

class Node {
    int data;
    Node left, right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}
class BinaryTree {
    static Node root;

    Node sortedArrayToBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
        node.left = sortedArrayToBST(arr, start, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, end);
        return node;
    }

    void printIt(Node root) {
        int h = findHeight(root);
        int i;
        for (i = 1; i <= h; i++)
            printLevelOrder(root, i);
        System.out.println("");
    }


    int findHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(node.right), findHeight(node.left));
    }


    void printLevelOrder(Node root, int level) {

        if (root == null && level == 1) {
            System.out.print("null ");
            return;
        }
        if (root == null && level != 1) {
            Node r = new Node(28282828);
            root = r;
            root.left = r;
            root.right = r;
            System.out.print("null ");
        }
        if (root.data == 28282828 && level != 1) {
            System.out.print("null ");
        }
        if (level == 1 && root.data != 28282828) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            printLevelOrder(root.left, level - 1);
            printLevelOrder(root.right, level - 1);
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        String instruction = sc.nextLine();
        Pattern pattern = Pattern.compile(" ");
        String[] words = pattern.split(instruction);
        int[] bookNumbers = new int[words.length];
        for (int i = 0; i < words.length; i++)
            bookNumbers[i] = Integer.parseInt((words[i]).trim());
        root = tree.sortedArrayToBST(bookNumbers, 0, words.length- 1);
        tree.printIt(root);
    }
}