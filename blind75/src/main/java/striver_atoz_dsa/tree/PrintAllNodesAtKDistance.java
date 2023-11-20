package striver_atoz_dsa.tree;

import striver_atoz_dsa.tree.traversal.DFS_Traversal;

import java.util.*;

public class PrintAllNodesAtKDistance {

    public static void main(String[] args) {
        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10
        TreeNode root = DFS_Traversal.getTree();

        // given a node value and k, we need to find out all the nodes at kth distance from given node
        int node = 2;
        int k = 2;

        Set<Integer> nodesAtKthDist = new LinkedHashSet<>();
        getNodesAtKthDistance(root, node, k, nodesAtKthDist);
        System.out.println("Nodes at kth distance :: " + nodesAtKthDist);

    }

    private static void getNodesAtKthDistance(TreeNode root, int target, int k, Set<Integer> nodesAtKthDist) {
        // Step 1: we need to build the tree with parent pointer


        Map<TreeNode, TreeNode> parentInfo = new LinkedHashMap<>();
        makeParentTrack(root, parentInfo);


        // here I have the value so, first we need to fetch
        // the node reference else proceed directly with target node ref.
        TreeNode targetNodeRef = getNodeRef(root, target);
        if (targetNodeRef!=null) {
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<TreeNode> visitedNodes = new LinkedList<>();
            queue.offer(targetNodeRef);
            visitedNodes.add(targetNodeRef);

            int targetK = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                if (targetK == k) {
                    break;
                }
                targetK++;

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();


                    if (node.left!=null && !visitedNodes.contains(node.left)) {
                        visitedNodes.add(node.left);
                        queue.offer(node.left);
                    }
                    if (node.right!=null && !visitedNodes.contains(node.right)) {
                        visitedNodes.add(node.right);
                        queue.offer(node.right);
                    }
                    if (parentInfo.get(node)!=null && !visitedNodes.contains(parentInfo.get(node))) {
                        visitedNodes.add(parentInfo.get(node));
                        queue.offer(parentInfo.get(node));
                    }
                }
            }

            // final queue contains all the nodes at kth distance
            while (!queue.isEmpty()) {
                nodesAtKthDist.add(queue.poll().val);
            }

        }


    }

    public static TreeNode getNodeRef(TreeNode root, int target) {
        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10

        if (root == null) return null;
        TreeNode node = null;
        if (root.val!=target) {
            // check for left right
            if (root.left!=null)
                node = getNodeRef(root.left, target);

            if (node==null && root.right!=null)
                node = getNodeRef(root.right, target);
        }  else {
            node = root;
        }

        return node;
    }

    public static void makeParentTrack(TreeNode root, Map<TreeNode, TreeNode> parentInfo) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parentInfo.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentInfo.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }


}
