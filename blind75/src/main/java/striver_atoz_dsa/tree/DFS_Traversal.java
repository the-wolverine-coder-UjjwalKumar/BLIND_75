package striver_atoz_dsa.tree;

import java.util.Stack;

public class DFS_Traversal {
    public static Node getTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(7);
        root.right.right = new Node(8);

        root.left.right.left = new Node(6);

        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        return root;
    }
    public static void main(String[] args) {

        Node root = getTree();
        // Print DFS traversal
        // 1. Pre-Order  (Root Left Right)
        // 2. In-Order   (Left Root Right)
        // 3. Post-Order (Left Right Root)

        System.out.print("Pre-Order :: ");
        printPreOrder(root);
        System.out.println();
        System.out.print("Pre-Order Iterative :: ");
        printPreorderIterative(root);
        System.out.println();
        System.out.print("In-Order :: ");
        printInOrder(root);
        System.out.println();
        System.out.print("Post-Order :: ");
        printPostOrder(root);
    }

    private static void printPostOrder(Node root) {
        if (root == null)
            return;

        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data+" ");
    }

    private static void printInOrder(Node root) {
        if (root == null)
            return;

        printInOrder(root.left);
        System.out.print(root.data+" ");
        printInOrder(root.right);
    }

    private static void printPreOrder(Node root) {

        if (root == null) {
            return;
        }

        // move to extreme left subtree
        System.out.print(root.data+" ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    private static void printPreorderIterative(Node root) {
        Stack<Node> stack = new Stack<>();

        // initial setup : put the root into stack
        // take out stack top & print it
        // put the right first & then left if exists

        if (root == null)
            return;

        stack.add(root);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            System.out.print(currentNode.data+" ");

            if (currentNode.right != null)
                stack.push(currentNode.right);

            if (currentNode.left != null)
                stack.push(currentNode.left);
        }
    }

    private static void printInOrderIterative(Node root) {
        if (root == null)
            return;

        // Approach: initialize the stack with root
        // now explore the top element and if its left exists put it into the stack
        // once left existence is null, take out the top print it out and then put the right
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        Node node = root;
        while (true) {

            if (node.left!=null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty())
                    break;

                node = stack.pop();
                System.out.print(node.data+" ");
                node = node.right;
            }

        }
    }
}
