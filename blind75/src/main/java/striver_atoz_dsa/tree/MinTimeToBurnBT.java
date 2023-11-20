package striver_atoz_dsa.tree;

import com.sun.source.tree.Tree;
import striver_atoz_dsa.tree.traversal.DFS_Traversal;

import java.util.*;

import static striver_atoz_dsa.tree.PrintAllNodesAtKDistance.getNodeRef;
import static striver_atoz_dsa.tree.PrintAllNodesAtKDistance.makeParentTrack;

public class MinTimeToBurnBT {

    public static void main(String[] args) {
        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10
        TreeNode root = DFS_Traversal.getTree();

        // given a node value from where burning will start this will either node reference or val, here value
        int node = 2;
        int time = getTimeTakenToBurn(root, node);

        System.out.println("Time taken to burn the binary tree from node :: " + node + ", time = " + time);
    }

    private static int getTimeTakenToBurn(TreeNode root, int nodeVal) {

        Map<TreeNode, TreeNode> parentInfo = new LinkedHashMap<>();
        Map<TreeNode, Boolean> visitedBurntNodes = new LinkedHashMap<>();
        int timer = 0;
        makeParentTrack(root, parentInfo);

        TreeNode nodeRef = getNodeRef(root, nodeVal);

        if (nodeRef != null) {
            // perform the burning

            // perform a BFS traversal with visited array i.e. marked as burned and inc timer
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(nodeRef);
            visitedBurntNodes.put(nodeRef, true);

            while (!queue.isEmpty()) {

                int size = queue.size();
                boolean burntHappend = false;

                for (int i = 0; i < size; i++) {
                    TreeNode currNode = queue.poll();

                    if (currNode != null) {

                        // check for left child to burn
                        if (!visitedBurntNodes.getOrDefault(currNode.left, false)) {
                            burntHappend = true;
                            queue.offer(currNode.left);
                            visitedBurntNodes.put(currNode.left, true);
                        }

                        // check for right child to burn
                        if (!visitedBurntNodes.getOrDefault(currNode.right, false)) {
                            burntHappend = true;
                            queue.offer(currNode.right);
                            visitedBurntNodes.put(currNode.right, true);
                        }

                        // check for parent to burn
                        if (!visitedBurntNodes.getOrDefault(parentInfo.get(currNode), false)) {
                            burntHappend = true;
                            queue.offer(parentInfo.get(currNode));
                            visitedBurntNodes.put(parentInfo.get(currNode), true);
                        }

                    }

                }

                if (burntHappend) timer++;
            }
        }

        return timer;
    }

}
