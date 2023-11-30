package striver_atoz_dsa.tree;

import striver_atoz_dsa.tree.traversal.DFS_Traversal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructBinaryTreeFromInOrderPreOrder {
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        List<Integer> inorder = List.of(40, 20, 50, 10, 60, 30);
        List<Integer> preOrder = List.of(10, 20, 40, 50, 30, 60);

        for (int i = 0; i < inorder.size(); i++) {
            map.put(inorder.get(i), i);
        }

        TreeNode root = constructBinaryTree(inorder, preOrder, 0, inorder.size()-1, 0
                , preOrder.size()-1);
        System.out.println("Given Inorder :: "+inorder);
        System.out.print("Final Inorder :: ");
        DFS_Traversal.printInOrder(root);
    }

    private static TreeNode constructBinaryTree(List<Integer> inorder,
                                                List<Integer> preOrder, int inStart, int inEnd,
                                                int preStart, int preEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preOrder.get(preStart));

        // for left subtree inOrder and preOrder boundaries
        int inS = inStart;
        int inE = map.get(preOrder.get(preStart)) - 1;
        int preS = preStart + 1;
        int preE = preStart + (inE - inS + 1);
        root.left = constructBinaryTree(inorder, preOrder, inS, inE, preS, preE);

        // for right subtree inOrder an preOrder boundaries
        inS = map.get(preOrder.get(preStart)) + 1;
        inE = inEnd;
        preS = preE + 1;
        preE = preE + (inE - inS + 1);
        root.right = constructBinaryTree(inorder, preOrder, inS, inE, preS, preE);
        return root;

    }
}
