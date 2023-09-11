package striver_atoz_dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
        System.out.print("In-Order Iterative :: ");
        printInOrderIterative(root);
        System.out.println();
        System.out.print("Post-Order :: ");
        printPostOrder(root);
        System.out.println();
        System.out.print("Post-Order Iterative :: ");
        printPostOrderIterativeTwoStack(root);
        System.out.println();
        System.out.print("Post-Order Iterative using one sack :: ");
        printPostOrderIterativeOneStack(root);
        System.out.println();
        System.out.println("Pre/Inorder/Post-Order in single go :: ");
        printPreOrderInOrderPostOrder(root);
        System.out.println();
    }


    private static void printPostOrder(Node root) {
        if (root == null)
            return;

        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " ");
    }

    private static void printInOrder(Node root) {
        if (root == null)
            return;

        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    private static void printPreOrder(Node root) {

        if (root == null) {
            return;
        }

        // move to extreme left subtree
        System.out.print(root.data + " ");
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
            System.out.print(currentNode.data + " ");

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


            if (node != null && node.left != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty())
                    break;

                node = stack.pop();
                System.out.print(node.data + " ");
                node = node.right;
            }
        }


    }

    public static void printPostOrderIterativeTwoStack(Node root) {
        if (root == null)
            return;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();

            if (node != null) {
                stack2.push(node);

                if (node.left != null)
                    stack1.push(node.left);

                if (node.right != null)
                    stack1.push(node.right);
            }

        }

        while (!stack2.isEmpty()) {
            Node node = stack2.pop();
            System.out.print(node.data + " ");
        }
    }

    public static void printPostOrderIterativeOneStack(Node root) {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();

        Node curr = root;
        Node temp;
        while (curr != null || !stack.isEmpty()) {

            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                temp = stack.peek().right;
                if (temp == null) {
                    // print the post order
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    curr = temp;
                }
            }
        }
    }

    private static void printPreOrderInOrderPostOrder(Node root) {
        List<Integer> preOrder = new LinkedList<>();
        List<Integer> inOrder = new LinkedList<>();
        List<Integer> postOrder = new LinkedList<>();

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {
            Pair topEle = stack.pop();
            if (topEle.cnt == 1) {
                preOrder.add(topEle.getNode().data);

                topEle.setCount(2);
                stack.push(topEle);

                if (topEle.getNode().left != null) {
                    stack.push(new Pair(topEle.getNode().left, 1));
                }
            } else if (topEle.cnt == 2) {
                inOrder.add(topEle.getNode().data);

                topEle.setCount(3);
                stack.push(topEle);

                if (topEle.getNode().right != null) {
                    stack.push(new Pair(topEle.getNode().right, 1));
                }
            } else if (topEle.cnt == 3) {
                postOrder.add(topEle.getNode().data);
            }
        }

        System.out.println("Pre-Order :: "+preOrder);
        System.out.println("In-Order :: "+inOrder);
        System.out.println("post-Order :: "+postOrder);

    }

    static class Pair {
        Node node;
        int cnt;

        public Pair(Node node, int cnt) {
            this.node = node;
            this.cnt = cnt;
        }

        public void setNode(Node node) {
            this.node = node;
        }

        public void setCount(int count) {
            this.cnt = count;
        }

        public Node getNode() {
            return this.node;
        }

        public int getCount() {
            return this.cnt;
        }

    }
}
