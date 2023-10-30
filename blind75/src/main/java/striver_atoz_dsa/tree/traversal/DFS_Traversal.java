package striver_atoz_dsa.tree.traversal;

import striver_atoz_dsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFS_Traversal {
    public static TreeNode getTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(6);

        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10

        return root;
    }

    public static void main(String[] args) {

        TreeNode root = getTree();
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


    private static void printPostOrder(TreeNode root) {
        if (root == null)
            return;

        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void printInOrder(TreeNode root) {
        if (root == null)
            return;

        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    private static void printPreOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        // move to extreme left subtree
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    private static void printPreorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        // initial setup : put the root into stack
        // take out stack top & print it
        // put the right first & then left if exists

        if (root == null)
            return;

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode currentTreeNode = stack.pop();
            System.out.print(currentTreeNode.val + " ");

            if (currentTreeNode.right != null)
                stack.push(currentTreeNode.right);

            if (currentTreeNode.left != null)
                stack.push(currentTreeNode.left);
        }
    }

    private static void printInOrderIterative(TreeNode root) {
        if (root == null)
            return;

        // Approach: initialize the stack with root
        // now explore the top element and if its left exists put it into the stack
        // once left existence is null, take out the top print it out and then put the right
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        TreeNode treeNode = root;
        while (true) {


            if (treeNode != null && treeNode.left != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                if (stack.isEmpty())
                    break;

                treeNode = stack.pop();
                System.out.print(treeNode.val + " ");
                treeNode = treeNode.right;
            }
        }


    }

    public static void printPostOrderIterativeTwoStack(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode treeNode = stack1.pop();

            if (treeNode != null) {
                stack2.push(treeNode);

                if (treeNode.left != null)
                    stack1.push(treeNode.left);

                if (treeNode.right != null)
                    stack1.push(treeNode.right);
            }

        }

        while (!stack2.isEmpty()) {
            TreeNode treeNode = stack2.pop();
            System.out.print(treeNode.val + " ");
        }
    }

    public static void printPostOrderIterativeOneStack(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        TreeNode temp;
        while (curr != null || !stack.isEmpty()) {

            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                temp = stack.peek().right;
                if (temp == null) {
                    // print the post order
                    temp = stack.pop();
                    System.out.print(temp.val + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.val + " ");
                    }
                } else {
                    curr = temp;
                }
            }
        }
    }

    private static void printPreOrderInOrderPostOrder(TreeNode root) {
        List<Integer> preOrder = new LinkedList<>();
        List<Integer> inOrder = new LinkedList<>();
        List<Integer> postOrder = new LinkedList<>();

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {
            Pair topEle = stack.pop();
            if (topEle.cnt == 1) {
                preOrder.add(topEle.getNode().val);

                topEle.setCount(2);
                stack.push(topEle);

                if (topEle.getNode().left != null) {
                    stack.push(new Pair(topEle.getNode().left, 1));
                }
            } else if (topEle.cnt == 2) {
                inOrder.add(topEle.getNode().val);

                topEle.setCount(3);
                stack.push(topEle);

                if (topEle.getNode().right != null) {
                    stack.push(new Pair(topEle.getNode().right, 1));
                }
            } else if (topEle.cnt == 3) {
                postOrder.add(topEle.getNode().val);
            }
        }

        System.out.println("Pre-Order :: "+preOrder);
        System.out.println("In-Order :: "+inOrder);
        System.out.println("post-Order :: "+postOrder);

    }

    static class Pair {
        TreeNode treeNode;
        int cnt;

        public Pair(TreeNode treeNode, int cnt) {
            this.treeNode = treeNode;
            this.cnt = cnt;
        }

        public void setNode(TreeNode treeNode) {
            this.treeNode = treeNode;
        }

        public void setCount(int count) {
            this.cnt = count;
        }

        public TreeNode getNode() {
            return this.treeNode;
        }

        public int getCount() {
            return this.cnt;
        }

    }
}
